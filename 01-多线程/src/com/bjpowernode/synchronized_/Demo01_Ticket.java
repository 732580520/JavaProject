package com.bjpowernode.synchronized_;

public class Demo01_Ticket {
    public static void main(String[] args) {
        // 创建线程任务对象
        Ticket ticket = new Ticket();
        // 创建线程对象
        Thread t1 = new Thread(ticket, "窗口一");
        Thread t2 = new Thread(ticket, "窗口二");
        Thread t3 = new Thread(ticket, "窗口三");
        Thread t4 = new Thread(ticket, "窗口四");
        // 启动线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
