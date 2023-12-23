package com.gyb.jse2test.test01;

import java.util.Arrays;

public class Test02 {

    public static void method01(){
        int N = 1000;
        int a = 0;
        for(int i = 0; i < N; i++){
            a = 3 + 6;
            a = 3 - 4;
            a = 3 * 4;
        }
    }
    public static void method02(){
        int N = 1000;
        int a = 0;
        for(int i = 0; i < N; i++){
            a = 3 |6;
            a = 3 & 4;
            a = 3 ^ 4 ^ 8;
        }
    }

    public static void main(String[] args) {
        //一组数一种出现奇数次的数
        /*int[] arr1 = {1,1,1,2,3,2,2,3,2};
        int result = 0;
        for(int each : arr1){
            result ^= each;
        }
        System.out.println(result);

        //一组数两种出现奇数次的数
        int[] arr2 = {4,4,4,4,4,1,1,1,2,3,2,2,3,2};
        int eor = 0;
        for(int each : arr2){
            eor ^= each;
        }
        int rightOne = eor & (~eor + 1);
        int a = 0;
        int b;
        for(int each : arr2){
            if((each & rightOne) != 0){
                a ^= each;
            }
        }
        b = eor ^ a;
        System.out.println(a + "\n" + b);*/
        int[] arr = {9,7,7,7,7,5,5,5,5,5,5,5,5,5,5,5,4,3,3,3,2,2,1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr) + arr.length);
//
//        myBinarySearch(arr,6);
        myBinarySearch2(arr,8);
    }
    public static void insertSort(int[] arr) {
        if(arr == null || arr.length < 2){
            return;
        }

        for(int i = 1; i < arr.length; i++){
            for(int j = i-1; j >= 0 && arr[j] > arr[j+1]; j--){
                arr[j]  = arr[j] ^ arr[j+1];
                arr[j+1] = arr[j] ^ arr[j+1];
                arr[j] = arr[j] ^ arr[j+1];
            }
        }
    }

    public static void myBinarySearch(int[] arr, int num){
        int middle = -1;
        int left = 0;
        int right = arr.length-1;
//        insertSort(arr);

        while(left != right){
            middle = (left + right)/2;
            if(arr[middle] == num){
                break;
            }
            if(num > arr[middle]){
                left = middle + 1;
            }else if(num < arr[middle]){
                right = middle -1;
            }
        }
        System.out.println(middle);
    }
    public static void myBinarySearch2(int[] arr, int num){
        int middle=-1;
        int left = 0;
        int right = arr.length-1;
//        insertSort(arr);
        int resultIndex = -1;
        while(left != middle){
            middle = (left + right)/2;

            if(num > arr[middle]){
                resultIndex = middle;
                left = middle + 1;
            }else if(num <= arr[middle]){
                resultIndex = middle;
                right = middle -1;
            }
        }
        System.out.println(resultIndex);
    }

}
