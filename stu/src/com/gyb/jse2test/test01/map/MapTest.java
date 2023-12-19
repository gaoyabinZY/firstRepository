package com.gyb.jse2test.test01.map;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        /*
        //HashMap
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"zhangsan");
        map.put(7,"lisi");
        map.put(3,"wangwu");
        map.put(6,"zhaoliu");
        map.put(6,"jack");
        map.put(null,null);
        map.put(null,"nilaizhende?");*/

        /*
        //TreeMap
        Map<Integer,String> map = new TreeMap<>();
        map.put(1,"zhangsan");
        map.put(7,"lisi");
        map.put(3,"wangwu");
        map.put(6,"zhaoliu");
        map.put(6,"jack");
        map.put(null,null);

        System.out.println(map);*/


        /*//LinkedHashMap
        Map<Integer,String> map = new LinkedHashMap<>();
        map.put(1,"zhangsan");
        map.put(7,"lisi");
        map.put(3,"wangwu");
        map.put(6,"zhaoliu");
        map.put(6,"jack");
        map.put(null,null);

        System.out.println(map);*/

        //HashTabel
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"zhangsan");
        map.put(7,"lisi");
        map.put(3,"wangwu");
        map.put(6,"zhaoliu");
        map.put(6,"jack");
        map.put(null,null);
        System.out.println(map);

        Set<Integer> keys = map.keySet();
        Collection<String> values = map.values();
        for(Integer key:keys){
            System.out.println("key:" + key);
        }
        for(String value:values){
            System.out.println("value:" + value);
        }

        //Entry<K,V> map接口属性，可以当作是一种数据类型
        //下行代码把map集合变为 泛型为双列模式的（Entry<Entry<K,V>）的单列集合Set
        Set<Map.Entry<Integer, String>> entryMap = map.entrySet();
        for(Map.Entry<Integer,String> each:entryMap){
            System.out.println(each);//key=value
            System.out.println(each.getKey());//key
            System.out.println(each.getValue());//value
        }
    }
}
