package com.bjpowernode.lock;

public class Demo01_Lock {
    public static void main(String[] args) {
        // 创建线程任务对象
        Ticket ticket = new Ticket();
        // 创建线程对象
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);
        Thread t4 = new Thread(ticket);
        // 启动线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
