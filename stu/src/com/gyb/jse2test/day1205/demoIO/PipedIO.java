package com.gyb.jse2test.day1205.demoIO;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;

public class PipedIO {
    public static void main(String[] args) {
        Sender sender  = new Sender();
        Receiver receiver = null;
        try {
            receiver = new Receiver(sender);
            Thread senderThread = new Thread(sender);
            Thread receiverThread = new Thread(receiver);

            senderThread.start();
            receiverThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


//发送信息线程
class Sender extends Thread{
    //字符输出管道流对象
    private PipedWriter out = new PipedWriter();

    public PipedWriter getOut(){
        return this.out;
    }

    @Override
    public void run() {
        while(true){
            for (char c = 'A'; c < 'Z'; c++) {
                try {
                    out.write(c);
//                    sleep(new Random().nextInt(1000));
                    sleep(1000);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

//接收信息线程
class Receiver extends Thread{
    //管道接收流对象需要指定输出流对象，建立管道连接
    private PipedReader in;

    public Receiver(Sender sender) throws IOException {
        this.in = new PipedReader(sender.getOut());
    }

    @Override
    public void run() {
        try {
            while(true){
                System.out.print((char)in.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}