package com.gyb.jse2test.test01.set;

import com.gyb.jse2test.test01.list.Person;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class HashSetTest {
    public static void main(String[] args) {
//        Set<String> stringSet = new HashSet<>();
//        stringSet.add("aaa");
//        stringSet.add("bbb");
//        stringSet.add("ccc");
//        stringSet.add("ccc");//F
//        stringSet.add("ddd");
//        stringSet.add("eee");
//        stringSet.add("eee");//F
//        System.out.println(stringSet.add("eee"));//F
//
//
//        System.out.println(stringSet);//[aaa, ccc, bbb, eee, ddd]
//
//        //清空集合 clear()
//        stringSet.clear();
//        System.out.println(stringSet);//[]

        /*Set<Integer> integerSet = new TreeSet<>();
        integerSet.add(5);
        integerSet.add(8);
        integerSet.add(2);
        integerSet.add(4);
        integerSet.add(9);
        System.out.println(integerSet);//[2, 4, 5, 8, 9]

        Set<String> stringSet = new TreeSet<>();
        stringSet.add("c");
        stringSet.add("a");
        stringSet.add("B");
        stringSet.add("d");
        stringSet.add("df");
        stringSet.add("de");
        System.out.println(stringSet);//[B, a, c, d, de, df]*/

        /*Set<Integer> integerSet = new LinkedHashSet<>();
        integerSet.add(5);
        integerSet.add(8);
        integerSet.add(2);
        integerSet.add(4);
        integerSet.add(9);
        System.out.println(integerSet);//[5, 8, 2, 4, 9]*/
        Set<Person> personSet = new TreeSet<>();
        personSet.add(new Person("ahangsan",20));
        personSet.add(new Person("cisi",23));
        personSet.add(new Person("bangwu",21));
        System.out.println(personSet);
    }
}
