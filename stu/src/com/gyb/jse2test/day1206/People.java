package com.gyb.jse2test.day1206;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 编写多线程应用程序，模拟多个人通过一个山洞的模拟。
 * 这个山洞每次只能通过一个人，每个人通过山洞的时间为5秒，
 * 随机生成10个人，同时准备过此山洞，显示一下每次通过山洞人的姓名。
 */
public class People extends Thread{
    private static ReentrantLock lock = new ReentrantLock();
    private String name;
    public People(String name){
        this.name = name;
    }
    @Override
    public void run() {
        lock.lock();
        try{
            System.out.println(this.name + "  进入山洞");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println(this.name + " 离开山洞");
        }
    }

    public static void main(String[] args) {
//        test01();
        test02();
    }

    /**
     * 任务委托方式
     */
    public static void test01(){
        ExecutorService es = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 10; i++) {
            es.execute(new People("山洞人" + i + "号"));
        }
        es.shutdown();
    }

    /**
     * 锁方式
     */
    public static void test02(){
        for (int i = 0; i < 10; i++) {
            new People("山洞人" + i + "号").start();
        }
    }

    /**
     * 锁+委托
     */
    /*public static  void test03(){
        ExecutorService es = Executors.newFixedThreadPool(1);
        Set<People> peopleSet = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            peopleSet.add(new People("山洞人" + i + "号"));
        }
        es.invokeAny(peopleSet);
        es.shutdown();
    }*/
}
