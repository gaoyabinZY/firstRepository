package com.gyb.jse2test.iotest.chario;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderTest {
    public static void main(String[] args) {

        try(FileReader fr = new FileReader("D:\\A\\FileWriterTest.txt")){
            int read = 0;
            while((read=fr.read()) != -1){
                System.out.print((char)read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
