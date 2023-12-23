package com.gyb.jse2test.day1207.work;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<Student> clazz = Student.class;
        Constructor<Student> constructor = clazz.getConstructor();
        Student student = constructor.newInstance();

        Field name = clazz.getDeclaredField("name");
        Field age = clazz.getDeclaredField("age");

        name.set(student,"张三");
        age.set(student,20);

        System.out.println("姓名：" + name.get(student) + "    年龄：" + age.get(student));
    }
}
