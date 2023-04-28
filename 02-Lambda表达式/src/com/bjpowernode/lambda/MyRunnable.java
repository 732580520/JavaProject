package com.bjpowernode.lambda;
/*
    1.声明Runnable接口实现类
    2.实现类重写run方法
    3.创建实现类对象
    4.创建线程对象 传递线程任务
    5.启动线程
    最终目的:启动线程 执行线程任务
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("线程任务 run.....");
    }
}
