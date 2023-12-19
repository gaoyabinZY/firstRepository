package com.gyb.jse2test.day1205;

public class Bank {
    private double balance;
    private final String passbook="passbook";
    private final String card="card";

    public Bank(){
        super();
    }

    public Bank(double balance){
        this.balance = balance;
    }

    /*@Override
    public void run() {
        if("passbook".equals(this.passbook)){

        }
    }*/
    public void widthdraw(String way){
        if(way.equals(this.passbook)){
            this.balance -= 1000;
            System.out.println("存折取钱1000元，余额：" + this.balance);
        }else if(way.equals(this.card)){
            this.balance -= 1000;
            System.out.println("银行卡取钱1000元，余额：" + this.balance);
        }else{
            return;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class Account extends Thread{
    private String way;
    private Bank bank;
    static final Object obj = new Object();

    public Account(String name, String way, Bank bank){
        super(name);
        this.way = way;
        this.bank = bank;
    }

    @Override
    public void run() {
        while (true){
            synchronized(obj) {
                if (bank.getBalance()-1000 < 0) {
                    break;
                }
                bank.widthdraw(this.way);
            }
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank(500000);
        Account account1 = new Account("A", "passbook", bank);
        Account account2 = new Account("B", "card", bank);
        Thread t1 = new Thread(account1);
        Thread t2 = new Thread(account2);

        t1.start();
        t2.start();
    }
}