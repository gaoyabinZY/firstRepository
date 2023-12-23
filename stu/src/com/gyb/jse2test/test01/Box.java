package com.gyb.jse2test.test01;

public class Box<T> {
    private T t;
    public T getT(){
        return t;
    }

    public void setT(T t){
        this.t = t;
    }
//
//    public static void main(String[] args) {
//        Box<Integer> integerBox = new Box<>();
//        Box<String> stringBox = new Box<>();
//
//        stringBox.setT("asdfsdf");
//        integerBox.setT(new Integer("15"));
//
//
//    }
}

class Box1{
//    public static void main(String[] args) {
//        Integer[] arr1 = new Integer[]{1,2,3,1};
//        String[] arr2 = new String[]{"aaa","bbb","ccc","ddd"};
//
//        Box1.printArray(arr1);
//        System.out.println();
//        Box1.printArray(arr2);
//    }

    /**
        泛型方法
        打印输出一个数组
    */
    public static <E> void printArray(E[] inputArr){
        for (E each : inputArr){
            System.out.print(each + "\t");
        }
    }
}

class A1<T>{

}
class B1{
    public <T> void method01(A1<? extends T> a11){
        //A1的类型参数必须为T的子类
    }

    public <E> void method02(A1<? super E> a1){
        //A1的类型参数必须为E的父类
    }
}

class A2<T>{
    private T t;
    public A2(T t){
        this.t = t;
    }

    public T getT() {
        System.out.println(t.getClass() + "\n");
        return t;
    }

    public static void main(String[] args) {
        Integer i1 = new Integer("12");
        A2<Integer> a2 = new A2<>(i1);
        a2.getT();

    }
}
