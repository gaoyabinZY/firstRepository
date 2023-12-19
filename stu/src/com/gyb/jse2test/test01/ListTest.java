package com.gyb.jse2test.test01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ListTest {
    public static void main(String[] args) {

        //创建Collection集合，使用Collection接口，ArrayList集合
        Collection<Integer> collection01 = new ArrayList();

        //添加元素，public boolean add(Object obj)
//        collection01.add("abc");
        collection01.add(100000);
        collection01.add(1);
        collection01.add(12);
        collection01.add(123);
        for (Integer each: collection01) {
            System.out.println(each);
        }

        Iterator<Integer> iterator = collection01.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }



    }
}
