package com.gyb.jse2test.day1205.demoproanncusm;

//生产者线程
public class Producer extends Thread{
    Product p;  //产品
    Customer customer;
    public Producer(Product p){
        this.p = p;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void run(){

        //生产者生产产品过程，永真循环
        while(true){
            //同步代码块 产品是锁
            synchronized (p){
                if(p.isFlag()){
                    //有产品，阻塞等待，通知消费者消费
                    try {
                        p.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    //无产品，生产产品
                    p.setName("笔记本");
                    p.setPrice(3.00);
                    p.setFlag(true);
                    System.out.println("生产者生产了一个笔记本");
                    p.notify();
            }
            }
        }
    }

}
