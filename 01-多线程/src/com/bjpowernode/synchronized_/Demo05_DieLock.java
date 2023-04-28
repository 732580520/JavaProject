package com.bjpowernode.synchronized_;

public class Demo05_DieLock {
    public static void main(String[] args) throws InterruptedException {
        // 创建线程任务对象
        DieLock dl = new DieLock();
        // 创建线程对象
        Thread t1 = new Thread(dl);
        Thread t2 = new Thread(dl);
        // 启动线程
        t1.start();

        Thread.sleep(1);
        dl.flag = true;
        t2.start();

    }
}
