package com.gyb.jse2test.day1207;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMyAnnotation{


    @MyAnnotation(url = "https://www.baidu.com",name = "百度")
    public static void test(String url,String name){
        System.out.println(url);
        System.out.println(name);
    }

}

class A{
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //获取使用了注解的方法
        Method method = TestMyAnnotation.class.getMethod("test");
        //获取该方法的注解
        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
        //获取注解中的属性值
        String url = annotation.url();
        String name = annotation.name();
        //调用使用了注解的方法
        method.invoke(MyAnnotation.class.newInstance(),url);

    }
}