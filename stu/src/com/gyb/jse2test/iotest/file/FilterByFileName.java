package com.gyb.jse2test.iotest.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class FilterByFileName implements FilenameFilter {
    //文件类型
    private String type;

    public FilterByFileName(String type){
        this.type = type;
    }

    //筛选满足的条件
    @Override
    public boolean accept(File dir, String name) {
        //以字符串type结尾
        boolean flag = name.endsWith(type);
        return flag;
    }
}

class FilenameFilterTest{
    public static void main(String[] args) {
        File file = new File("D:/WeSingCache/WeSingDL/Res/000JlUCR2Fa5nf");
        File[] files1 = file.listFiles();
        System.out.println(Arrays.toString(files1));
        System.out.println("************************************************************************");

        File[] files2 = file.listFiles(new FilterByFileName("note"));
        System.out.println(Arrays.toString(files2));
    }
}