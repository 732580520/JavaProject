package com.bjpowernode.synchronized_;

public class Demo02_Ticket02 {
    public static void main(String[] args) {
        // 创建线程对象
        Ticket02 t1 = new Ticket02();
        Ticket02 t2 = new Ticket02();
        Ticket02 t3 = new Ticket02();
        Ticket02 t4 = new Ticket02();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
