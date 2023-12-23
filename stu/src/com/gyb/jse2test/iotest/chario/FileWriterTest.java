package com.gyb.jse2test.iotest.chario;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
    public static void main(String[] args) {
        try(FileWriter fileWriter = new FileWriter("D:\\A\\FileWriterTest.txt")) {
//            FileWriter fileWriter = new FileWriter("D:\\A\\FileWriterTest.txt");
            //write()可以写入 数据内容 数字，字符串，字符数组
            fileWriter.write(123);
            //系统换行
            fileWriter.write(System.getProperty("line.separator"));
            fileWriter.write("hello world!");
            //使用转义字符换行
            fileWriter.write("\r\n");
            fileWriter.write(new char[]{'a','b','c','d'});
            fileWriter.write("\r");
            fileWriter.write(51515515);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
