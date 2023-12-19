package com.gyb.jse2test.day1208;

public class Test01 {

    public static void main(String[] args) {
        String str = "abcdef";
        str = str.substring(3);
        System.out.println(str);
//        str.finalize();
        A a = new A();
        try {
            a.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
}

class A{

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}