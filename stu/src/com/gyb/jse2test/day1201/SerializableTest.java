package com.gyb.jse2test.day1201;

import java.io.*;

/**
 * @author 沾水米粉
 */
public class SerializableTest {
    public static void main(String[] args) {
        try {
//            test01();
            test02();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //把对象序列化写入硬盘
    public static void test01() throws IOException {
        //ObjectOutputSteam
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\A\\person.obj"));
        Person p = new Person("zhangsan",30,"高新园区");
        oos.writeObject(p);

        oos.close();
    }

    //反序列化，读出对象
    public static void test02() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\A\\person.obj"));
        Person p = (Person) ois.readObject();
        System.out.println(p.getName());
        System.out.println(p.getAge());
        System.out.println(p.getAddr());
    }

}
