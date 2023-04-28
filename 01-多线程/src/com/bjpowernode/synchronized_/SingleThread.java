package com.bjpowernode.synchronized_;

public class SingleThread implements Runnable {
    // 线程的任务就是获取单例对象
    @Override
    public void run() {
        Single s = Single.getInstance();
        System.out.println(s);
    }
}
