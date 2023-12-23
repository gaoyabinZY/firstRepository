package com.gyb.jse2test.iotest.file;

import java.io.File;
import java.util.Arrays;

public class FileTest01 {
    public static void main(String[] args) {
        String s0 = "";
        String s1 = "/filetest.txt";
        String s2 = "src/com/gyb/jse2test/iotest/file/filetest.txt";
        String s3 = "src\\com\\gyb\\jse2test\\iotest\\file\\filetest.txt";
        File file1 = new File(s2);
        System.out.println(file1.length());
        System.out.println("parent:" + file1.getParent());
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.lastModified());
//        System.out.println(Arrays.toString(file1.list()));
//        file1.
        File file2 = new File("D:/A");
        System.out.println(file2.length());
        System.out.println(file2.isDirectory());


    }
}
