package com.gyb.jse2test.test02;

import java.util.Arrays;

public class StackTest {
    public static void main(String[] args) {

    }
}

class MyStack{

    private int[] arr;

    // size 记录栈中元素个数
    private int size;

    public MyStack(){
        // 调用无参构造方法 默认最大容量12
        this(12);
    }

    public MyStack(int MaxSize){
        this.arr = new int[MaxSize];
    }

    // 入栈
    public int push(int value){
        if(this.size == arr.length){
            // 栈满 ,需要扩容

            int[] copyArr;
            // 复制arr 数组并扩容一倍
            copyArr = Arrays.copyOf(arr,2 * arr.length);
            arr = copyArr;

        }
        //将元素添加到size位置
        this.arr[size] = value;
        // 元素个数加一
        this.size++;
        // 返回添加元素
        return value;
    }

    // 出栈
    public int pop(){
        if(isEmpty()){
            //没有元素
            //抛出运行时异常,此处也可以自定义异常
            throw new RuntimeException("栈中没有元素,不能出栈....");
        }
        // 获得栈顶元素
        int value = this.arr[size - 1];
        // size - 1 之后, 下一次插入时会覆盖原数据,利用覆盖替代删除
        this.size--;
        return value;
    }

    // 获取栈顶元素
    public int peek(){
        if(isEmpty()){
            //没有元素
            //抛出运行时异常,此处也可以自定义异常
            throw new RuntimeException("栈中没有元素,不能出栈....");
        }
        return this.arr[this.size - 1];
    }

    //获取元素个数
    public int getSize(){
        return this.size;
    }

    //判断元素是否为空
    public boolean isEmpty(){
        return this.size == 0;
    }
}
