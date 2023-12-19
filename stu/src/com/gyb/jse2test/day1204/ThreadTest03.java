package com.gyb.jse2test.day1204;

import java.sql.SQLOutput;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadTest03 {
    public static void main(String[] args) {
        CallableTest threadA = new CallableTest("A");
        CallableTest threadB = new CallableTest("B");

        //FutureTask封装实现类，用来存储call的返回值
        FutureTask<Integer> futureTaskA = new FutureTask<>(threadA);
        FutureTask<Integer> futureTaskB = new FutureTask<>(threadB);

        //封装线程
        Thread thread1 = new Thread(futureTaskA);
        Thread thread2 = new Thread(futureTaskB);

        thread1.start();
        thread2.start();

        try {
            int sum = futureTaskA.get();
            System.out.println("-------------" + sum + "-------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

class CallableTest implements Callable<Integer>{
    String name;
    public CallableTest(String name){
        this.name = name;
    }


    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for(int i = 0; i < 100; i++){
            sum += i;
            System.out.println(this.name + i);
        }
        return sum;
    }
}
