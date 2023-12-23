package com.gyb.jse2test.test01.list;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        personList.add(0,new Person("zhangsan",20));
        personList.add(1,new Person("lisi",21));
        personList.add(2,new Person("wangwu",22));
        personList.add(new Person("jack",23));//尾部添加
        personList.add(1,new Person("jack",23));//占用位置1，后面元素后移

        System.out.println(personList);
    }
}

