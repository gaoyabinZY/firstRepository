package com.gyb.jse2test.iotest.bufferedio;

import java.io.*;

public class BufferedRWTest {
    public static void main(String[] args) {
        String path1 = "D:\\A\\bufferedReaderTest.txt";
        String path2 = "D:\\A\\bufferedWriterTest.txt";
        String path3 = "D:\\A\\aaa.txt";
        String path4 = "D:\\A\\bbb.txt";
        String path5 = "D:\\A\\ccc.txt";
        String path6 = "D:\\A\\ddd.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(path3));
            BufferedWriter bw = new BufferedWriter(new FileWriter(path4));
        ){
            String read = "";
            while((read = br.readLine()) != null){
                bw.write(read);
                bw.newLine();

            }
            //缓冲流缓冲区满了自动清除，最后输出流关闭时也会先调用flush
            //也可以调用以下

        } catch(IOException e){
            e.printStackTrace();
        } catch(Exception e){
            e.printStackTrace();
        }
        /*try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path1));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path2))
        ) {
            byte[] inputs = new byte[1024];
            while(bis.read(inputs) != -1){
                bos.write(inputs);
//                bos.write(););
                bos.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}
