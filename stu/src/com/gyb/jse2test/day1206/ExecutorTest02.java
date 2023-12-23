package com.gyb.jse2test.day1206;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class ExecutorTest02 {

    public static void main(String[] args) {
//        test02();
//        test03();
        test04();

    }

    public static void test02(){
        ExecutorService es = Executors.newFixedThreadPool(3);


        //submit(Ruanable)
        Future future = es.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });

        Future future1 = es.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName());
                return "callabletest";
            }
        });
        es.shutdown();
    }

    public static void test03(){
        ExecutorService es = Executors.newFixedThreadPool(5);
        Set<Callable<String>> callables = new HashSet<>();
        callables.add(new MyThread1());
        callables.add(new MyThread1());
        callables.add(new MyThread1());
        callables.add(new MyThread1());
        callables.add(new MyThread1());

//        List<Future<String>> futures = es.invokeAll(callables);
        try {
            String invokeAny = es.invokeAny(callables);
            System.out.println(invokeAny);
            es.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void test04(){
        ExecutorService es = Executors.newFixedThreadPool(5);
        Set<Callable<String>> callables = new HashSet<>();
        callables.add(new MyThread1());
        callables.add(new MyThread1());
        callables.add(new MyThread1());
        callables.add(new MyThread1());
        callables.add(new MyThread1());

//        List<Future<String>> futures = es.invokeAll(callables);
        try {
            List<Future<String>> futures = es.invokeAll(callables);
            for(Future<String> each : futures){
                System.out.println(each.get());
            }
            es.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }


    static class MyThread1 implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "task::" + Thread.currentThread().getName();
        }
    }
}
