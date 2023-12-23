package com.gyb.jse2test.day1207;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ConstructorTest {

    public void testConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取Class对象
        Class<A01> clazz = A01.class;
        //获取Constructor对象
        Constructor<A01> constructor1 = clazz.getConstructor(null);
        System.out.println("无参构造对象 —— " + constructor1);
        Constructor<A01> constructor2 = clazz.getConstructor(String.class);
        System.out.println("有参构造对象 —— " + constructor2);

        //获取Constructor对象信息
        System.out.println("构造方法名：" + constructor2.getName());
        System.out.println("构造方法所属类" + constructor2.getDeclaringClass());
        System.out.println("构造方法参数个数" + constructor2.getParameterCount());
        System.out.println("构造方法参数类型数组" + Arrays.toString(constructor2.getParameterTypes()));

        //通过Constructor创建对象
        A01 a01 = constructor2.newInstance(clazz);
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ConstructorTest test = new ConstructorTest();
        test.testConstructor();
    }
}

class A01{
    private String name;

    public A01() {
    }

    public A01(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "A01{" +
                "name='" + name + '\'' +
                '}';
    }
}
