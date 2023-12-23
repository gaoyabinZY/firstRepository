package com.gyb.jse2test.test01;

import java.util.*;

public class Test1127 {
    public static void main(String[] args) {
        /*
        * 1、利用map集合存储以下信息  key-学号，value-姓名
              1001  小帅
              1002  小美
              1003  FBl
              1004  卡了米
            打印输出所有信息，打印格式：  学号-xxxx,姓名-xxx
            输入一个学号，查找是否存在，如果存在，输出对应姓名，如果不存在，输出“查无此人”
            打印输出所有姓‘小’的学生的学号
        * *//*
        Map<String,String> stuMap = new HashMap<>();
        stuMap.put("1001","小帅");
        stuMap.put("1002","小美");
        stuMap.put("1003","FBl");
        stuMap.put("1004","卡了米");
        Set<Map.Entry<String,String>> entrySet = stuMap.entrySet();
        for(Map.Entry<String,String> each: entrySet){
            System.out.println("学号-" + each.getKey() + ",姓名-" + each.getValue());
        }

        //查询byId
        Scanner sc = new Scanner(System.in);
        String stuId = sc.next();
        mySearch(stuMap,stuId);

        //打印输出所有姓‘小’的学生的学号
        for(Map.Entry<String,String> each:entrySet){
            if(each.getValue().charAt(0) == '小'){
                System.out.println("学号-" + each.getKey() + ",姓名-" + each.getValue());
            }
        }*/

        /*
        *有数组 arr {2,2,3,3,3,4,4,4,4,5,5,2,2,2}
            找出值最大的元素
            找出出现次数最多的元素及其出现次数
        * */

        int[] arr = {2,2,3,3,3,4,4,4,4,5,5,2,2,2};

        //放入集合中
        Map<Integer,Integer> map = new TreeMap<>();
        for(int each:arr){
            if(map.containsKey(each)){
                map.put(each,map.get(each)+1);
            }else{
                map.put(each,1);
            }
        }
        System.out.println(map);

        Collection<Integer> values = map.values();
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

        //找到最大值
        System.out.println("最大值：" + Collections.max(values));

        //出现最多元素以及出现次数
        int max = 0;
        int n = arr[0];
        for(Map.Entry<Integer,Integer> each:entries){
            max = each.getValue() > max ? each.getValue() : max;
            if(each.getValue() > max){
                max = each.getValue();
                n = each.getKey();
            }
        }
        System.out.println("最多出现数字是：" + n + "\n出现次数为：" + max);
    }

    public static void mySearch(Map<String,String> map,String id) {
        if(map.containsKey(id)){
            System.out.println(map.get(id));
        }else{
            System.out.println("查无此人");
        }
    }



    public static void test02(){

    }
}
