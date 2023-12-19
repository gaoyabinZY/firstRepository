package com.gyb.jse2test.iotest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomOutputStreamTest {
    public static void main(String[] args) {
        File file = new File("D:\\aaa.txt");
        try(RandomAccessFile raf = new RandomAccessFile(file,"rw")){
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
