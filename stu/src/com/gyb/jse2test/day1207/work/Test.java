package com.gyb.jse2test.day1207.work;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    private String s;

    public Test() {
    }

    public Test(String s) {
        this.s = s;
    }

    public void method01(){
        System.out.println("method1被调用");
    }

    public void method02(int n){
        System.out.println("method2被调用");
    }

    private void method03(){
        System.out.println("method3被调用");
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<Test> clazz = Test.class;
        Test test = clazz.getConstructor().newInstance();

        //获取方法
        Method method1 = clazz.getMethod("method01");
        Method method2 = clazz.getMethod("method02", int.class);
        Method method3 = clazz.getDeclaredMethod("method03");
        method1.invoke(test);
        method2.invoke(test,2);
        method3.invoke(test);

        //获取参数
        Field s = clazz.getDeclaredField("s");
        s.set(test,"set s by field");
        System.out.println(s.get(test));


    }
}
