package com.gyb.jse2test.test01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Test01 {
    public static void main(String[] args) {
        //转换对象类型
        Integer i1 = 1;
        String str1 = "aaa";
        Object o1 = i1;
        Object o2 = str1;
        Integer i2 = MyCast.myClassCast(o1);
        String str2 = MyCast.myClassCast(str1);

        //填满数组
        String[] strArr = new String[10];
        Integer[] integerArr = new Integer[20];
        MyCast.fillArr(strArr,"sdf");
        MyCast.fillArr(integerArr,1);
        System.out.println(Arrays.toString(strArr));
        System.out.println(Arrays.toString(integerArr));

        //把一个数据类型的数据复制到另一个数组
        //旧数组
        Integer[] integerArr2 = {1,8,9,4,1,6,4};
        String[] strArr2 = {"aa","bb","cc"};

        //新数组
        Integer[] integerArr3 = new Integer[integerArr2.length];
        String[] strArr3 = new String[strArr2.length];

        MyCast.myArrayCopy(strArr2,strArr3);
        MyCast.myArrayCopy(integerArr2,integerArr3);
        System.out.println(Arrays.toString(strArr3));
        System.out.println(Arrays.toString(integerArr3));

        //打印集合中的所有内容
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("aaaa");
        arrayList.add("bbbb");
        arrayList.add("cccc");
        MyCast.collectionPrint(arrayList);

        //将集合中的内容复制到相应类型的数组中
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(1);
        arrayList1.add(1);
        arrayList1.add(1);
        Integer[] integerArr4 = new Integer[arrayList1.size()];

        MyCast.copyCollectionToArray(arrayList1, integerArr4);
        System.out.println(Arrays.toString(integerArr4));

    }
}

class MyCast{
    public static <T> T myClassCast(Object obj){
        return (T)obj;
    }

    public static <E> void fillArr(E[] eArr, E eObj){
        for(int i = 0; i < eArr.length; i++){
            eArr[i] = eObj;
        }
    }
    public static <T> void myArrayCopy(T[] arr1,T[] arr2){
        for(int i = 0; i < arr1.length; i++){
            arr2[i] = arr1[i];
        }
    }

    public static <T> void collectionPrint(Collection<T> collection){
        Iterator iterator = collection.iterator();
        while(iterator.hasNext()){
            System.out.print("\n" + iterator.next());
        }
    }

    public static <E> void copyCollectionToArray(Collection<E> collection, E[] arr){
        Iterator iterator = collection.iterator();
        for(int i = 0; i < arr.length; i++){
            if(!iterator.hasNext()) {
                return;
            }
            arr[i] = (E) iterator.next();
        }
    }
}