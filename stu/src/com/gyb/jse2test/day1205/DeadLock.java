package com.gyb.jse2test.day1205;

public class DeadLock extends Thread{
    public DeadLock(String name){
        super(name);
    }

    @Override
    public void run() {
        if ("张三".equals(this.getName())){
            synchronized("手枪"){
                System.out.println("李四拿到手枪，准备拿子弹");
                synchronized("子弹"){
                    System.out.println("拿到子弹，射🐓🐔🐤🍗");
                }
            }
        }else if ("李四".equals(this.getName())){
            synchronized("子弹"){
                System.out.println("李四拿到子弹，准备拿手枪");
                synchronized("手枪"){
                    System.out.println("拿到子弹，射🐓🐔🐤🍗");
                }
            }
        }
    }

    public static void main(String[] args){
        DeadLock d1 = new DeadLock("张三");
        DeadLock d2 = new DeadLock("李四");

        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);

        t1.start();
        t2.start();
    }
}
