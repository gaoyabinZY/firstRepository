package com.gyb.jse2test.test01.list;

import java.math.BigInteger;
import java.util.*;

public class Test01 {
    public static void main(String[] args) {
//        long number = 59084709587505L;
        BigInteger number = new BigInteger("59084709587505");
        SortedSet<BigInteger> resultSet = new TreeSet<>();

        resultSet.add(BigInteger.valueOf(3L));
        resultSet.add(BigInteger.valueOf(5L));
        resultSet.add(BigInteger.valueOf(7L));

        SortedSet<BigInteger> tempSet = new TreeSet<>(resultSet);//被乘数集合
        Set<BigInteger> oldSet = new TreeSet<>();
        Long count = 0L;
        while(!resultSet.contains(number)){
            tempSet.removeAll(oldSet);//去掉之前使用过的数据
            oldSet = new TreeSet<>(resultSet);//本次录入数据前先保存数据
            Iterator iterator = tempSet.iterator();
            while(iterator.hasNext()){
                count++;
                BigInteger each = (BigInteger) iterator.next();
                resultSet.add(each.multiply(BigInteger.valueOf(3L)));
                resultSet.add(each.multiply(BigInteger.valueOf(5L)));
                resultSet.add(each.multiply(BigInteger.valueOf(7L)));
            }
            tempSet.addAll(resultSet);
        }
        System.out.println(resultSet);
        List<BigInteger> list = new ArrayList<>(resultSet);
        System.out.println(list.indexOf(number));
        System.out.println("count:" + count);
    }

}
