package com.gyb.jse2test.day1204;

/**
 *  实现Runnable接口
 */

public class ThreadTest02 {
    public static void main(String[] args) {
        RunnableImpl threadA = new RunnableImpl("A");
        RunnableImpl threadB = new RunnableImpl("B");

        //创建一个线程类最为外壳，将自定义线程对象封装起来
        Thread thread1 = new Thread(threadA);
        Thread thread2 = new Thread(threadB);
        thread1.start();
        thread2.start();

    }

}

class RunnableImpl implements Runnable{
    String name;

    public RunnableImpl(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(this.name + i);
        }
    }
}