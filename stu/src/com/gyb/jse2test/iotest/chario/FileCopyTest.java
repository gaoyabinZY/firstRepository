package com.gyb.jse2test.iotest.chario;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyTest {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("D:\\A\\file1.txt");
             FileWriter fileWriter = new FileWriter("D:\\A\\file2.txt")
        ) {
            int read = 0;
            while((read=fileReader.read()) != -1){
                fileWriter.write(read);
                fileWriter.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
