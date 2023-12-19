package com.gyb.jse2test.day1205;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

//模拟功能，多个线程总共发起5000次请求，每次请求向字符串添加一个字符，校验字符串长度
public class StringExample{
    //请求总数
    public static int clientTotal = 5000;

    //同时并发执行的线程数
    public static int threadTotal = 200;

    //目标字符串、对象
    public static StringBuilder str = new StringBuilder();

    private static void update(){
        str.append("1");
    }

    public static void main(String[] args) throws InterruptedException {
        //ExecutorService是jdk提供的线程池，可以通过设置线程池，自动创建多个线程并执行
        ExecutorService executorService = Executors.newCachedThreadPool();

        //Semaphore是线程同步的辅助类，可以维护当前访问自身的线程个数，并且提供了同步机制
        final Semaphore semaphore = new Semaphore(threadTotal);

        //CountDownLatch是多线程控制的一个工具，被称为倒数计数器（门阀/闭锁）用来协助线程同步
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        //创建线程并发送请求（执行update（））
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(()->{
                //为线程申请一个许可证
                try {
                    semaphore.acquire();

                    update();

                    //释放一个线程许可证
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //总请求数 倒数计数
                countDownLatch.countDown();

            });
        }

        //线程等待，等待线程执行完毕，防止阻塞
            countDownLatch.await();
            executorService.shutdown();
            System.out.println("str的长度：" + str.length());

    }
}
