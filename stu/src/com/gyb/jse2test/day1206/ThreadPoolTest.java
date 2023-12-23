package com.gyb.jse2test.day1206;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    public static void main(String[] args){
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1,3,0,
                TimeUnit.MICROSECONDS, new LinkedBlockingDeque <>(3));
        MyThread thread = new MyThread();
        pool.execute(thread);
        pool.execute(thread);
        pool.execute(thread);

        System.out.println("" + pool.getCorePoolSize());
        System.out.println("" + pool.getPoolSize());
        System.out.println("" + pool.getQueue().size());
    }
}
