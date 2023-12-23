package com.gyb.jse2test.test01.map;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
        //原始数据为list集合
        List<String> list = new ArrayList<>();
        list.add("张一,上海");
        list.add("张二,上海");
        list.add("张三,广州");
        list.add("张四,深圳");
        list.add("张五,北京");
        list.add("张六,深圳");

        //创建Map集合
        Map<String,List<String>> map  = new HashMap<>();

        for(String each:list){
            String[] key_value = each.split(",");
            String key = key_value[1];
            String value = key_value[0];
            if(map.containsKey(key)){
                //有key直接添加value
                map.get(key).add(value);
            }else{
                //无key先添加key和new List，再添加value
                List<String> nameList = new ArrayList<>();
                nameList.add(value);
                map.put(key, nameList);
            }
        }
        Set<Map.Entry<String, List<String>>> entrySet = map.entrySet();
        for(Map.Entry<String, List<String>> each: entrySet){
            System.out.print(each.getKey() + ", " + each.getValue().size() + " : ");
            StringBuilder nameStr = new StringBuilder();
            for(String name:each.getValue()){
                if(name.equals(each.getValue().get(0))){
                    nameStr.append(name);
                }else{
                    nameStr.append("," + name);
                }
            }
            System.out.println(nameStr);
        }
    }
}
