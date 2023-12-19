package com.gyb.jse2test.day1204;

public class ThreadStopTest extends Thread{
    private boolean flag = true;

    //新建普通动态方法 改变开关属性
    public void stopThread(){
        this.flag = false;
    }

    @Override
    public void run() {
        int i = 0;
        while(this.flag){
            try {
                Thread.sleep(3600*10);
            } catch (InterruptedException e) {
    //            e.printStackTrace();
                System.out.println("thread execute loop" + i++);
                flag=false;

            }
        }
    }

    public static void main(String[] args) {
        ThreadStopTest threadStopTest = new ThreadStopTest();
        threadStopTest.start();
        threadStopTest.interrupt();//中断睡眠
    }
}
