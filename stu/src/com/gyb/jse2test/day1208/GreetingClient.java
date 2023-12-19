package com.gyb.jse2test.day1208;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class GreetingClient {

    //将类中（线程对象中，任务中）需要用到的相关类的对象作为属性
    private Socket socket=null;
    private BufferedWriter writer=null;

    public GreetingClient(){
        System.out.println("客户端运行");

        //启动匿名线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                //利用Socket通讯类建立线程间通道
                while(true){
                    try {
                        //每次传输数据，新建一个通道
                        //Socket(String IP, int port)
                        GreetingClient.this.socket = new Socket("127.0.0.1",8090);
                        //实例化字符流对象
                        writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                        writer.write(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format( new Date()));
                        writer.flush();
                        TimeUnit.SECONDS.sleep(3);
                        writer.close();
                        if(writer != null){
                            writer.close();
                        }
                        if (GreetingClient.this.socket != null) {
                            GreetingClient.this.socket.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        GreetingClient greetingClient = new GreetingClient();
    }
}


class Service{
    private Socket socket;
    private ServerSocket service;
    private BufferedReader reader;
    private int count=0;

    private void service() throws IOException {
        service = new ServerSocket(8090);
        System.out.println("服务器运行");
        while(true){
            //socket建通通讯 接收放编码格式
            //ServerSocket放接收连接accept()
            socket = service.accept();
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String value = reader.readLine();
            System.out.println("第" + count++ + "次" + "接收的请求,请求内容" + value);
        }
    }

    public static void main(String[] args) throws IOException {
        Service service = new Service();
        service.service();
    }
}