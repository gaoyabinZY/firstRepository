package com.gyb.jse2test.day1205.demoproanncusm;

//消费者线程
public class Customer extends Thread {
    Product p;

    public Customer(Product p) {
        this.p = p;

    }

    @Override
    public void run() {
        while(true){
            synchronized (p){
                if(p.isFlag()){
                    //消费
                    p.setFlag(false);
                    System.out.println("消费者消费了");
                    p.notify();

                }else{
                    //无产品
                    try {
                        p.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

}
