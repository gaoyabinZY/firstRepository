package com.gyb.jse2test.day1207;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class FieldTest {

    public void testField() throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<A03> clazz = A03.class;
        Constructor<A03> constructor = clazz.getConstructor();
        A03 a03 = constructor.newInstance("张三", 20);

        //获取属性对象
        Field field1 = clazz.getField("name");
        Field field2 = clazz.getField("age");

        System.out.println("属性名" + field1.getName());
        System.out.println("所属类" + field1.getClass());
        System.out.println("获取对应类中对应属性的值" + field1.get(a03));
        field1.set(a03,"李四");
        System.out.println(field1.get(a03));
    }

    public static void main(String[] args) throws NoSuchFieldException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        FieldTest test = new FieldTest();
        test.testField();
    }

}


class A03{
    private String name;
    private int age;

    public A03() {
    }

    public A03(String name, int age) {
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
