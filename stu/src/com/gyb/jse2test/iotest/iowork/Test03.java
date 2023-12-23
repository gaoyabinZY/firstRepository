package com.gyb.jse2test.iotest.iowork;

import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        String filePath = "D:\\A\\ccc.txt";
//        myPrint(filePath);

        Scanner sc = new Scanner(System.in);
        String filePath2 = "src/com/gyb/jse2test/iotest/iowork/users.csv";
        System.out.println("输入用户名");
        String username = sc.next();
        System.out.println("输入密码");

        if(sc.next() == "Y"){
//            changePwd(filePath2,username,password);
        }
    }


}
