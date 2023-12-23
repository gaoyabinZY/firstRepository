package com.gyb.jse2test.iotest.file;

import java.io.File;

public class FileTest04 {
    public static void main(String[] args) {
        File file = new File("D:/A/2377/javaSE IO体系");
        System.out.println(file.mkdirs());
    }
}
