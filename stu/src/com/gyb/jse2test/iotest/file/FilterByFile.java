package com.gyb.jse2test.iotest.file;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Array;

public class FilterByFile implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        boolean flag = pathname.isHidden();
        return flag;
    }
}

class FileFilterTest{
    public static void main(String[] args) {
        File file = new File("D:/GameDownload");
        File[] files = file.listFiles(new FilterByFile());
        for(File each : files){
            System.out.println(each);
        }


    }
}
