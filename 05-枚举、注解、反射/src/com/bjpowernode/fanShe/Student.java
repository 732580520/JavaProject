package com.bjpowernode.fanShe;

import java.util.Objects;

public class Student {
    // 成员变量
    @MyAnno(name="王顺龙")
    public String name;
    private int age;
    char sex;
    private static String addr;
    // 构造方法
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @MyAnno(name="伍成龙")
    private Student(String name) {
        this.name = name;
    }

    Student(int age) {
        this.age = age;
    }

    public Student() {
    }
    // 成员方法
    public String getName() {
        return name;
    }

    @MyAnno(name = "米尔康")
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    // 私有静态的成员方法
    private static void sleep() {
        System.out.println("Zzzzz.....");
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
