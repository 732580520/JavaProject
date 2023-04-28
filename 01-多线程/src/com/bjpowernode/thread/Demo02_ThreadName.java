package com.bjpowernode.thread;

public class Demo02_ThreadName {
    public static void main(String[] args) {
        // 创建线程对象
        MyThread t1 = new MyThread("来福..");
        /*MyThread t2 = new MyThread();
        t2.setName("常威.....");
        MyThread t3 = new MyThread();
        t3.setName("戚秦氏");*/
        // 启动线程
        t1.start();
       /* t2.start();
        t3.start();*/

        // 主线程
        for(int i = 1; i <= 20; i++ ) {
            System.out.println(Thread.currentThread().getName() + "........" + i);
        }

    }
}
