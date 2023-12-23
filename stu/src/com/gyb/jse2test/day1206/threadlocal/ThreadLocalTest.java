package com.gyb.jse2test.day1206.threadlocal;

public class ThreadLocalTest {
    ThreadLocal<Long> longLocal = new ThreadLocal<>();
    ThreadLocal<String> stringLocal = new ThreadLocal<>();

    public long getLong(){
        return longLocal.get();
    }
    public String getString(){
        return stringLocal.get();
    }

    public void set(){
        longLocal.set(Thread.currentThread().getId());//线程编号
        stringLocal.set(Thread.currentThread().getName());//线程名称
    }

    static Thread thread1=null;
    public static void main(String[] args) {
        final ThreadLocalTest test = new ThreadLocalTest();

        //初始化ThreadLocal对象
        test.set();
        System.out.println("main:" + test.getLong());
        System.out.println("main:" + test.getString());

        Thread thread1 = new Thread(){
            @Override
            public void run() {
                ThreadLocalTest.thread1 = Thread.currentThread();
                test.set();
                System.out.println("thread1 id:" + test.getLong());
                System.out.println("thread1 name:" + test.getString());
            }
        };

        Thread thread2 = new Thread(){
            @Override
            public void run() {
                //线程2不对其线程ThreadLocal进行初始化
//                test.set();
                System.out.println("thread2 id:" + test.getLong());
                System.out.println("thread2 name:" + test.getString());
            }
        };
        thread1.start();
        thread2.start();

        test.set();
        System.out.println("main:" + test.getLong());
        System.out.println("main:" + test.getString());
    }
}
