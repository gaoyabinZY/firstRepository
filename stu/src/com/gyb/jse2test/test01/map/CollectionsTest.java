package com.gyb.jse2test.test01.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");

        //添加元素 默认尾部添加
        Collections.addAll(list,"a","b","c");

        //自然排序 sort()  如果是自定义类，需要事项Comparable接口
        Collections.sort(list);

        //反转
        Collections.reverse(list);

        //获取最大最小值
        Collections.max(list);
        Collections.min(list);

        //查询元素  前提：集合元素有序
        Collections.binarySearch(list,"hello");
        //如果不存在，则返回-(若存在的位置+1)
        Collections.binarySearch(list,"wuhu");


    }
}
