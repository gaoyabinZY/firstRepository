package com.gyb.jse2test.day1207;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodTest {
    public void testMethod() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<A02> clazz = A02.class;
        A02 a02 = clazz.getConstructor().newInstance();
        //获取Method对象
        Method method1 = clazz.getMethod("sleep");
        Method method2 = clazz.getMethod("wakeUp", String.class);

        //调用方法
        method1.invoke(a02);
        method2.invoke(a02,"大马路");


        //查看方法信息
        System.out.println("所属类对象" + method2.getDeclaringClass());
        System.out.println("形参个数" + method2.getParameterCount());
        System.out.println("形参类型数组" + Arrays.toString(method2.getParameterTypes()));
        System.out.println("返回值类型" + method2.getReturnType());
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        MethodTest methodTest = new MethodTest();
        methodTest.testMethod();
    }
}

class A02{
    private String name;
    private int age;

    public A02() {
    }

    public A02(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sleep(){
        System.out.println("睡觉");
    }

    public void wakeUp(String location){
        System.out.println("在" + location + "睡觉");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "A02{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
