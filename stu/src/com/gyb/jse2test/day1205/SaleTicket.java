package com.gyb.jse2test.day1205;

/**
 *
 * @author 沾水米粉
 * @version 1.0
 * @since 1.0
 */
public class SaleTicket extends Thread{
    //count
    static int num = 50;

    //自定义一个Object对象作为锁
    static Object obj = new Object();

    public SaleTicket(String name){
        super(name);
    }

    @Override
    public void run() {
        while(true){
            synchronized(obj) {
                if (num > 0) {
                    num--;
                    System.out.println(this.getName() + " show--" + "now have *" + num + "* ticket");
                } else {
                    System.out.println("Don't have more ticket");
                    break;
                }
            }

        }
    }



    public static void main(String[] args) {
        SaleTicket sale1 = new SaleTicket("A");
        SaleTicket sale2 = new SaleTicket("B");
        SaleTicket sale3 = new SaleTicket("C");

        Thread threadA = new Thread(sale1);
        Thread threadB = new Thread(sale2);
        Thread threadC = new Thread(sale3);

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
