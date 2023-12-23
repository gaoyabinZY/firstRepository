package com.gyb.jse2test.iotest.file;

import java.io.File;

public class FileTest03 {
    public static void main(String[] args) {
//        File file = new File("D:/WeSingCache");
//        File[] files = file.listFiles();
//        for(File e : files){
//            System.out.println(e);
//        }
        /*long maxLength = 0;
        File resultFile = null;
        File file = new File("D:/WeSingCache/WeSingDL/Res/000JlUCR2Fa5nf");
        File[] files = file.listFiles();
        for(File each:files){
            if(each.isFile() && each.length() > maxLength){
                maxLength = each.length();
                resultFile = each;
            }
        }
        System.out.println("file:" + resultFile + "   ,length: " + maxLength);*/

        File file = new File("D:/WeSingCache");
        iteratorDirectory(file);
        

    }

    public static void iteratorDirectory(File directory){
        File[] files = directory.listFiles();
        if(files.length == 0){
            return;
        }
        for (File each:files){
            if(each.isFile()){
                System.out.println(each);
            }else if(each.isDirectory()){
                if(each.list().length > 0){
                    System.out.println(each);
                    iteratorDirectory(each);
                }else{
                    System.out.println(each);
                }
            }
        }
    }
}
