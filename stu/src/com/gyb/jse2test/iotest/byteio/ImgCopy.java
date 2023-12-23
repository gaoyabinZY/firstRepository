package com.gyb.jse2test.iotest.byteio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImgCopy {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("src/com/gyb/jse2test/iotest/byteio/zysbug.png");
            FileOutputStream fos = new FileOutputStream("src/com/gyb/jse2test/iotest/byteio/zysbug_copy.png");
        ) {
            int input = 0;
            while((input = fis.read()) != -1){
                fos.write(input);
                fos.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
