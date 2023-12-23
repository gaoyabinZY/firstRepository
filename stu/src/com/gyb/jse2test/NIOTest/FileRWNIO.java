package com.gyb.jse2test.NIOTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileRWNIO {

    public static void main(String[] args) {
        File file = new File("D:\\A\\aaa.txt");
        readWriterNIO(file);
    }


    public static void readWriterNIO(File src){

        //声明channel对象
        try(FileInputStream fis = new FileInputStream(src);
            //Channel对象需要使用原始IO流对象调用方法得到
            FileChannel fileChannel = fis.getChannel()
        ) {
            //2、创建缓冲区
            ByteBuffer buf = ByteBuffer.allocate(20);

            //3、建立缓冲区到通道的连接
            //连接的本质是读取

            //通道读取至缓冲区
            int bytesRead = fileChannel.read(buf);
            while(bytesRead != -1){
                buf.flip();
                while(buf.hasRemaining()){
                    System.out.print((char)buf.get());
                }
                //清空缓冲区
                buf.clear();
                bytesRead = fileChannel.read(buf);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
