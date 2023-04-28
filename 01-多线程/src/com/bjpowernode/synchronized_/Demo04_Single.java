package com.bjpowernode.synchronized_;

public class Demo04_Single {
    public static void main(String[] args) {
        // 创建线程任务
        SingleThread st = new SingleThread();
        // 创建线程对象
        Thread t1 = new Thread(st);
        Thread t2 = new Thread(st);
        Thread t3 = new Thread(st);
        Thread t4 = new Thread(st);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
