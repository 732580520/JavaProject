package com.bjpowernode.synchronized_;

public class Demo03_Ticket03 {
    public static void main(String[] args) {
        // 创建线程任务对象
        Ticket03 ticket03 = new Ticket03();
        // 创建线程对象
        Thread t1 = new Thread(ticket03);
        Thread t2 = new Thread(ticket03);
        Thread t3 = new Thread(ticket03);
        Thread t4 = new Thread(ticket03);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
