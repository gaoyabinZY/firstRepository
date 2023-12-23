package com.gyb.jse2test.iotest.iowork;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static java.lang.System.*;

public class Test02 {
    public static void main(String[] args) {
        String filePath = "D:\\A\\ccc.txt";
//        myPrint(filePath);

        Scanner sc = new Scanner(System.in);
        String filePath2 = "src/com/gyb/jse2test/iotest/iowork/users.csv";
        //3.1登录
        System.out.println("输入用户名");
        String username = sc.next();
        System.out.println("输入密码");
        String password = sc.next();
        login(filePath2,username,password);

        //3.2修改密码
        out.println("输入用户名");
        String name = sc.next();
        out.println("是否修改密码？Y/N");
        if("Y".equals(sc.next())){
            changePwd("src/com/gyb/jse2test/iotest/iowork/users2.csv",name);
        }
    }

    public static void login(String filePath, String username, String password){
        File file = new File(filePath);
        try(RandomAccessFile raf = new RandomAccessFile(file,"rw")){
            String line = "";
//            raf.seek(0);
            while((line=raf.readLine()) != null){
                if(line.contains(username)){
                    String[] split = line.split(",");
                    if (password.equals(split[2])){
                        out.println("登录成功");
                    }
                    System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void changePwd(String filePath, String username){
        File file = new File(filePath);
        try(RandomAccessFile raf = new RandomAccessFile(file,"rw")){
            Scanner sc = new Scanner(in);
            String line = "";
            while((line=raf.readLine()) != null){
                out.println(line);
                if(line.contains(username)){
                    String[] split = line.split(",");
                    out.println("请输入原密码：");
                    String password = sc.next();
                    String newPassword = null;
                    if (password.equals(split[2])){
                        out.println("密码正确，输入新密码：");
                        newPassword = sc.next();
                        //回退密码长度的指针
                        raf.seek(raf.getFilePointer() - split[2].length() -2);
                        raf.writeBytes(newPassword);
                        out.println("修改成功");
                        return;
                    }else{
                        out.println("密码错误");
                        return;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*public static void myPrint(String filePath){
        try(BufferedReader br = new BufferedReader(new FileReader(filePath));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out))
        ) {
            String read = "";
            while((read = br.readLine()) != null){
                bw.write(read);
                bw.newLine();
                bw.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
