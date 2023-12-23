package com.gyb.jse2test.day1206.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    private Lock lock = new ReentrantLock();

    public void test01(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + " test01上锁");
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " test01 run");
            }
            //休眠
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void test02(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + " test02上锁");
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " test02 run");
            }
            //休眠
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void test03(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName() + " test03上锁");
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " test03 run");
            }
            //休眠
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}

class A{
    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        new Thread(()->lockTest.test01()).start();
        new Thread(()->lockTest.test02()).start();
        new Thread(()->lockTest.test03()).start();


    }
}