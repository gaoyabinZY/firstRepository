package com.gyb.jse2test.test01;

import java.util.*;

public class Test03 {
    public static void main(String[] args) {
//        method01();
//        method02();
//        method03();
//        method04();
        method05("hhhhheeeeeelloooooo");
    }

    public static void method05(String str){
        char[] charArr = str.toCharArray();
        Set<Character> set = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();
        for(char each : charArr) {
            if (set.add(each)) {
                sb.append(each);
            }
        }
        String result = sb.toString();
        System.out.println(result);
    }

    public static void method04(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] charArr = str.toCharArray();

        //使用map吧？
        HashMap<Character,Integer> map = new HashMap<>();
        for(char each : charArr){
            if(map.get(each) == null){
                map.put(each,1);
            }else{
                map.put(each,map.get(each)+1);
            }
        }
        System.out.println(map);
    }

    public static void method01(){
        /*
         * 生成10个 1~100之间的整数 存储在一个list集合中
         * 使用迭代器！！ 输出该集合中元素
         * */
        Random random = new Random();
        List<Integer> numList = new ArrayList<>();

        for(int i = 0; i < 11; i++){
            int num = random.nextInt(100) + 1;
            numList.add(num);
        }
        Iterator iterator = numList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /*
    * 创建5个Book对象 放入 list集合中
         循环集合输出每本书的详细信息
    * */
    public static void method02(){
        //创建list
        List<Book> bookList = new ArrayList<>();

        //添加五个Book对象
        bookList.add(new Book("藏地密码",24.80,"何马","重庆出版社"));
        bookList.add(new Book("张爱玲文集",168.00,"张爱玲",""));
        bookList.add(new Book("至死不渝",29.80,"艾米","群言出版社"));
        bookList.add(new Book("山楂树之恋",25.00,"艾米","江苏文艺出版社"));
        bookList.add(new Book("猎头局中局",29.80,"萧东楼",""));

        //遍历
        Iterator iterator = bookList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static void method03(){
        //创建ArrayList
        List<Person> personList = new ArrayList<>();

        //添加五个Person对象
        personList.add(new Person("张一",21));
        personList.add(new Person("张二",22));
        personList.add(new Person("张三",23));
        personList.add(new Person("张四",24));
        personList.add(new Person("张五",25));

        //下标遍历  修改张三的年龄
        for(int i = 0; i < personList.size(); i++){
            if("张三".equals(personList.get(i).getName())){
                personList.get(i).setAge(28);
            }
        }

        //foreach遍历
        //先用另一个list接收，否则会发生ConcurrentModificationException
        List<Person> tempList = new ArrayList<>(personList);
        for(Person each : tempList){
            if(each.getAge() == 25){
                personList.remove(each);
            }
        }

        //遍历
        Iterator iterator = personList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

/*
* 创建一个类Book 成员变量 name书名 price书价格 press出版社 author作者
 */
class Book{
    private String name;
    private double price;
    private String press;
    private String author;

    public Book(String name, double price, String press, String author) {
        this.name = name;
        this.price = price;
        this.press = press;
        this.author = author;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", press='" + press + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
