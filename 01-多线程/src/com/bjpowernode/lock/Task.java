package com.bjpowernode.lock;

public class Task implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "执行线程任务...");
    }
}
