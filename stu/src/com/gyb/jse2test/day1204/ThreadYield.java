package com.gyb.jse2test.day1204;

public class ThreadYield {
    public static void main(String[] args) {
        MyThread02 threadA = new MyThread02("A");
        MyThread02 threadB = new MyThread02("B");

        threadA.start();
        threadB.start();

    }
}

class MyThread02 extends Thread{
    public MyThread02(){}
    public MyThread02(String name){
        this.setName(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName() + ":" + i);
            Thread.yield();
        }
    }
}
