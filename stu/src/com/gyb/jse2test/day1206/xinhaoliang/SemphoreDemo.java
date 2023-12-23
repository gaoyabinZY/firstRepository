package com.gyb.jse2test.day1206.xinhaoliang;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemphoreDemo implements Runnable{
    //只有五个许可
    static Semaphore sema = new Semaphore(5);

    @Override
    public void run() {
        try {
            //发送许可
            sema.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "run");

            //释放许可
            sema.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(20);
        //模拟20个客户端
        for(int i=0; i < 20; i++){
            es.execute(new SemphoreDemo());
        }
        es.shutdown();
    }

}

/**
 *
 */
class A{

}