package com.gyb.jse2test.day1206;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ExecutorTest {
    public static void main(String[] args) {
//        Thread
        test01();
//        test02();
//        test03();
    }

    public static void test01(){
        //newCachedThreadPool
        ExecutorService es1 = Executors.newCachedThreadPool();
        /*Runnable run1 = new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " I am runA");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Runnable run2 = new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " I am runB");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };*/

        //执行10次任务
        for (int i = 0; i < 5; i++) {
            es1.execute(new Runnable(){
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " I am runA");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            es1.execute(new Runnable(){
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " I am runB");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        es1.shutdown();
    }

    public static void test02(){
        //newFixedThreadPool(int numOfThread)
        ExecutorService es = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 50; i++) {
            es.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
        es.shutdown();
    }

    public static void test03(){
        ExecutorService es = Executors.newSingleThreadExecutor();
        Runnable run1 = new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " I am runA");
            }
        };
        Runnable run2 = new Runnable(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " I am runB");
            }
        };

        for (int i = 0; i < 10; i++) {
            es.execute(run1);
            es.execute(run2);
        }
        es.shutdown();
    }
}
