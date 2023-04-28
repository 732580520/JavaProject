package com.bjpowernode.thread;
/*
    创建线程的方式一
        1.声明Thread子类
        2.子类重写run方法
        3.创建子类对象
        4.启动线程
 */
public class MyThread extends Thread {
    // 构造方法 给线程命名
    public MyThread(String name) {
        super(name);
    }
    public MyThread() {
    }

    // 指定线程的任务
    @Override
    public void run() {
        for(int i = 1; i <= 2000000000; i++ ) {
            System.out.println(getName() + "..." + i);
        }
    }
}
