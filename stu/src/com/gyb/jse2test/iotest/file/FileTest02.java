package com.gyb.jse2test.iotest.file;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class FileTest02 {
    public static void main(String[] args) {
        //此时“一个文件.txt并不存在”
//        File file1 = new File("D:/A/一个文件.txt");
//        try {
//            file1.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        file1.renameTo(new File("D:/A/inner1/移动了文件.txt"));
//
//        //创建一个文件夹mkdir()
//        File file2 = new File("D:/A/INNER1");
//        file2.mkdir();
//
//        //循环创建目录及未存在的父目录
//        File file3 = new File("D:/A/b/c/d");
//        file3.mkdirs();
////        file3.delete();
//        file3.renameTo(new File("D:/A/inner1/ddd"));

//        File file = new File("src/com/gyb/jse2test/files/filetest.txt");
//        System.out.println(file.length());
//        System.out.println(file.renameTo(new File("src/com/gyb/jse2test/iotest/file/filetest.txt")));
        File file = new File("D:\\A");
        File[] files = file.listFiles(new A());

    }
}
class A implements FileFilter {

    @Override
    public boolean accept(File pathname) {
        return false;
    }
}
