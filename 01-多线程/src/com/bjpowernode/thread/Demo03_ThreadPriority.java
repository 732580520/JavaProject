package com.bjpowernode.thread;

public class Demo03_ThreadPriority {
    public static void main(String[] args) {
        // 创建3个线程对象
        MyThread t1 = new MyThread("优先级1...");
        t1.setPriority(1);
        System.out.println("t1.getPriority() = " + t1.getPriority());
        MyThread t2 = new MyThread("优先级5......");
        System.out.println("t2.getPriority() = " + t2.getPriority());
        MyThread t3 = new MyThread("优先级10..........");
        t3.setPriority(10);
        System.out.println("t3.getPriority() = " + t3.getPriority());
        // 启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}
