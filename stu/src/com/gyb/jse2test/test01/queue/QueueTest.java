package com.gyb.jse2test.test01.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> stringQueue = new LinkedList<>();
        stringQueue.add("aaa");
        stringQueue.add("bbb");
        stringQueue.add(("ccc"));

        System.out.println(stringQueue);

        while(stringQueue.size() > 0){
            System.out.println(stringQueue.remove());
        }
    }


}
