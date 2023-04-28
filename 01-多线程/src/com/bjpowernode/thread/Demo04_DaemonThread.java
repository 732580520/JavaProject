package com.bjpowernode.thread;
// 当程序中没有可执行的用户线程时，守护线程自动结束
public class Demo04_DaemonThread {
    public static void main(String[] args) {
        // 创建线程对象
        MyThread thread = new MyThread();
        // 设置为守护线程
        thread.setDaemon(true);
        System.out.println(thread.isDaemon());
        // 开启线程
        thread.start();

        // 主线程
        for(int i = 1; i < 200; i++) {
            System.out.println(Thread.currentThread().getName() + "....." + i);
        }
    }
}
