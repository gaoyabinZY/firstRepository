package com.gyb.jse2test.iotest.file;

import java.io.File;
import java.io.FilenameFilter;

public class FileTest05 {
    public static void main(String[] args) {
        /*File directory = new File("src/com/gyb/jse2test/iotest/file");
//        System.out.println(directory.getAbsolutePath());
        File[] files1 = directory.listFiles(file -> file.isFile() && file.getName().endsWith(".java"));
        for(File each:files1){
            System.out.println(each);
        }

        //这是对比
        System.out.println("******************************");
        File[] files2 = directory.listFiles(file -> file.isFile() && file.getName().endsWith(".txt"));
        for(File each:files2){
            System.out.println(each);
        }*/
        File file = new File("D:/A");
        deleteFiles(file);


    }

    public static void deleteFiles(File file){
        File[] files = file.listFiles();
        if(files == null && files.length == 0){
            return;
        }
        for(File each:files){
            if(each.isFile()){
                each.delete();
            }else{
                if(each.list().length != 0){
                    deleteFiles(each);
                }
            }
        }
    }
}

class FilterByName implements FilenameFilter{
    private String type;

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(type);
    }
}
