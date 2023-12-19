package com.gyb.jse2test.test02;

public class NodeTest {
    public static void main(String[] args) {
        MyLink link = new MyLink();
        link.addNode(1,10);
        link.addNode(2,11);
        link.addNode(3,12);
        link.addNode(4,13);
        link.addNode(5,14);

        //打印链表
        link.linkPrint();
        System.out.println("*********");

        //头部添加
        link.pushNode(6,15);
        link.linkPrint();
        System.out.println("*********");

        //指定位置添加
        link.addNode(1,7,16);
        link.addNode(5,8,17);
        link.addNode(8,9,18);

        link.linkPrint();
        System.out.println(link.getLength() + "*********");

        //指定位置删除
        link.removeNode(1);
        link.removeNode(link.getLength());
        link.removeNode(link.getLength()-1);
        link.linkPrint();
        System.out.println(link.getLength() + "*********");

        //根据索引查找节点
        System.out.println("key=" + link.getNode(1).getKey() + ",value=" +  link.getNode(1).getValue());
        System.out.println("key=" + link.getNode(link.getLength()/2).getKey() + ",value=" + link.getNode(link.getLength()/2).getValue());
        System.out.println("key=" + link.getNode(link.getLength()).getKey() + ",value=" + link.getNode(link.getLength()).getValue());
        System.out.println("**********");


        MyLink link2 = new MyLink();
        link2.addNode(1,10);
        link2.addNode(2,20);
        link2.addNode(3,30);
        link2.addNode(4,40);
        link2.addNode(5,50);
//        link2.addNode(6,60);
        link2.linkPrint();
        System.out.println("**********");
        //反转
        link2.reverse();
        link2.linkPrint();
        System.out.println("******");

        //合并有序链表
        MyLink link3 = new MyLink();
        link3.addNode(1,1);
        link3.addNode(2,2);
        link3.addNode(3,3);
        MyLink link4 = new MyLink();
        link4.addNode(1,1);
        link4.addNode(2,2);
        link4.addNode(3,3);

        link3.concatLink(link4);
        link3.linkPrint();
    }
}
class MyLink{
    private Node head;
//    private Node foot;
    private int length;

    public MyLink(){
        this.head = null;
    }

    /*
    * 以下是关于添加节点的几种方法
    * addNode(int key, int value)尾部添加节点
    * addNode(int index,int key, int value)指定位置添加节点
    * pushNode(int key, int value)头部插入节点
    * */
    //尾部添加节点
    public void addNode(int key, int value){
        //若是空链表，当前节点为首节点
        if(this.head == null){
            this.head = new Node(key,value);
        }else{
            //找到空节点（尾节点）
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = new Node(key,value);
        }
        this.length++;
    }

    //指定位置插入节点
    public void addNode(int index,int key,int value){
        int currentIndex = 1;
        if(index < 1 || index > this.length){
            System.out.println("IndexOutOfBounds");
            return;
        }

        Node newNode = new Node(key,value);
        //如果是首节点（1位置插入）
        if(index == 1){
            newNode.next = head;
            this.head = newNode;
            this.length++;
            return;
        }
        Node current = head;
        while(currentIndex < index-1){
            current = current.next;
            currentIndex++;
        }
        //current就是索引位置前一个的节点
        newNode.next = current.next;
        current.next = newNode;
        this.length++;
    }

    //头部插入节点
    public void pushNode(int key,int value){
        //如果是空链表，当前节点为首节点
        if(this.head == null){
            this.head = new Node(key,value);
        }else{
            Node newNode = new Node(key,value);
            newNode.next = this.head;
            this.head = newNode;
        }
        this.length++;
    }

    /*
    * 以下是删除节点的方法
    * */
    //指定位置删除
    public boolean removeNode(int index){
        boolean flag = false;
        //空链表
        if(this.length == 0 || head == null){
            System.out.println("NoPointer");
            return false;
        }else if(index == 1){
            head = head.next;
            flag = true;
            this.length--;
        }else{
            Node current = this.head;
            int currentIndex = 1;
            while(currentIndex < index-1){
                current = current.next;
                currentIndex++;
            }
            //current是当前节点的前一个节点
            current.next = current.next.next;
            this.length--;
            flag = true;
        }
        return flag;
    }

    /*
    * 查找
    * */
    public Node getNode(int index){
        Node current = this.head;
        int currentIndex = 1;
        if(index ==1 ){
            return this.head;
        }
        while(currentIndex < index){
            current = current.next;
            currentIndex++;
        }
        return current;
    }

    /*
    * 反转
    * */
    public void reverse(){
//        if(this.length == 1){
//            return;
//        }else if(this.length == 2) {
//            Node foot = this.head.next;
//            foot.next = this.head;
//            this.head = foot;
//            return;
//        }
        Node prev = null;
        Node current = this.head;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        this.head = prev;
    }

    /*
    * 合并两个有序链表
    * */
    //合并两个有序链表
    public void concatLink( MyLink link2) {
        MyLink newLink = new MyLink();
        newLink.addNode(0,0);
//        Node headNode = new Node();
        Node tempNode = newLink.head;
        Node head1 = this.head;
        Node head2 = link2.head;
        while (head1 != null && head2 != null) {
            if (head1.getValue() < head2.getValue()) {
                tempNode.next = head1;
                head1 = head1.next;
            } else {
                tempNode.next = head2;
                head2 = head2.next;
            }
            tempNode = tempNode.next;
        }
        if (head1 == null) {
            tempNode.next = head2;
        }
        if (head2 == null) {
            tempNode.next = head1;
        }
        this.head = newLink.head.next;
    }



    public void linkPrint(){
        Node current = this.head;
        System.out.println("[key=" + current.getKey() + ",value=" + current.getValue() +"]");
        while(current.next != null){
            current = current.next;
            System.out.println("[key=" + current.getKey() + ",value=" + current.getValue() +"]");
        }
    }

    public int getLength() {
        return length;
    }
}
class Node{
    private int key;
    private int value;
    Node next;  // 指向下一个元素的引用

    public Node(){

    }
    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}