package com.bjpowernode.runnable;

public class Demo01_MyRunnable {
    public static void main(String[] args) {
        // 创建实现类对象 线程任务对象
        MyRunnable mr = new MyRunnable();
        // 创建线程对象 传递线程任务
        Thread thread = new Thread(mr);
        // 启动线程
        thread.start();
        // 创建线程对象
        Thread t1 = new Thread(mr);
        Thread t2 = new Thread(mr);
        t1.start();
        t2.start();


        // 主线程
        for(int i = 1; i <= 20; i++) {
            System.out.println(Thread.currentThread().getName() + "...." + i);
        }
    }
}
