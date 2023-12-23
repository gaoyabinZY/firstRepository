package com.gyb.jse2test.day1204;

public class ThreadJoinTest {
    public static void main(String[] args) throws InterruptedException {
        MyThread03 threadA = new MyThread03("A");
        MyThread03 threadB = new MyThread03("B");
        MyThread03 threadC = new MyThread03("C");
        MyThread03 threadD = new MyThread03("D");

        threadA.start();
//        threadA.join();
        System.out.println("main");
        threadB.start();
        threadB.join();
        threadC.start();
        threadD.start();

    }
}


class MyThread03 extends Thread{
    public MyThread03(){}
    public MyThread03(String name){
        this.setName(name);
    }
    @Override
    public void run() {
        for (int i = 0; i < 150; i++) {
            System.out.println(this.getName() + ":" + i);
//            Thread.yield();
        }
    }
}