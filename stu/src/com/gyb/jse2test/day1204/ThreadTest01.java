package com.gyb.jse2test.day1204;

public class ThreadTest01 {
    public static void main(String[] args) {
        MyThread myThreadA = new MyThread("A");
        MyThread myThreadB = new MyThread("B");
        myThreadA.start();
        myThreadB.start();
//        myThreadB.start();
        //两个线程互相争抢cpu资源
    }
}

class MyThread extends Thread{
    String name;
    public MyThread(String name){
        this.name = name;
    }

    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(this.name + i);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
