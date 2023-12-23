package com.gyb.jse2test.iotest.iowork;

import java.io.*;

public class ChUTF8 {
    public static void main(String[] args) {
        //定义文件路径,文件为GBK编码
        String path = "src/com/gyb/jse2test/iotest/iowork/users.csv";
        //创建读入流对象,指定GBK编码
        try(InputStreamReader isr2 = new InputStreamReader(new FileInputStream(path),"gbk");
            //创建输出流对象,默认UTF-8编码,定义路径
//            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("src/com/gyb/jse2test/iotest/iowork/users.csv"))
            OutputStreamWriter osw = new OutputStreamWriter((System.out))
        ){
            //定义变量,保存字符
            int len ;
            //使用指定 字符编码读取
            while((len = isr2.read()) != -1){ //循环读取
                osw.write(len);
//                System.out.println((char)len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
