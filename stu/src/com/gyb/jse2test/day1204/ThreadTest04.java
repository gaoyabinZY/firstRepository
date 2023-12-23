package com.gyb.jse2test.day1204;

public class ThreadTest04 {
    public static void main(String[] args) {
        /*
        //系统自动分配名称
        Thread thread1 = new Thread();

        //创建指定名称的线程
        Thread thread2 = new Thread("线程2");

        //利用Runnable对象创建线程
        Thread thread3 = new Thread(Runnable target);

        //利用Runnable对象创建指定名称线程
        Thread thread4 = new Thread(Runnable target,"线程4");
        */

        /**
         * 控制线程的几个静态方法

        //返回当前的线程对象
        System.out.println(Thread.currentThread());

        //使当前正在执行的线程休眠
        Thread.sleep(10);

        //让出时间片
        Thread.yield();

        //判断当前线程是否已经休眠
        System.out.println(Thread.interrupted());

         */
        MyThread01 thread1 = new MyThread01();
        MyThread01 thread2 = new MyThread01();
        MyThread01 thread3 = new MyThread01("自定义线程名");

        thread1.start();
//        thread1.start();
        thread2.start();
        thread3.start();

        thread1.setPriority(1);
        thread2.setPriority(10);
        System.out.println(thread1.getPriority());
        System.out.println(Thread.MIN_PRIORITY);//1
        System.out.println(Thread.MAX_PRIORITY);//10

        thread1.interrupt();
    }


}

class MyThread01 extends Thread{
    public MyThread01(){
    }
    public MyThread01(String name){
        this.setName(name);
    }
    @Override
    public void run() {
        System.out.println(this.getName());
    }
}