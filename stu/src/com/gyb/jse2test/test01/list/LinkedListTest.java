package com.gyb.jse2test.test01.list;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<Person> personList = new LinkedList<>();
        personList.add(0,new Person("zhangsan",20));
        personList.add(1,new Person("lisi",21));
        personList.add(2,new Person("wangwu",22));

        //头部/尾部添加   addFirst/addLast
        personList.addFirst(new Person("Tom",24));
        personList.addLast(new Person("Jerry",25));

        //头部/尾部获取   getFirst/getLast()
        System.out.println(personList.getFirst());
        System.out.println(personList.getLast());


        //头部/尾部删除   removeFirst/removeLast()
        personList.removeFirst();
        personList.removeLast();
        System.out.println(personList);

        //头部压入/头部弹出    push/pop
        personList.push(new Person("James",38));
        personList.push(new Person("James",39));
        personList.push(new Person("James",40));
        System.out.println(personList);
        personList.pop();
        System.out.println(personList);

        System.out.println("**********");
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);


    }
}
