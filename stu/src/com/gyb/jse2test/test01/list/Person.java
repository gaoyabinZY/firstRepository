package com.gyb.jse2test.test01.list;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        if (this.name.compareTo(o.name) >= 1) {
            return 1;
        } else if (this.name.compareTo(o.name) == 0) {
            return 0;
        } else {
            return -1;
        }
    }
}
