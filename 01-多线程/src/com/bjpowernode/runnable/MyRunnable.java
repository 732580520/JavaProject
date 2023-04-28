package com.bjpowernode.runnable;
/*
    创建线程的方式二：
        1.声明Runnable接口的实现类
        2.实现类重写run()方法
        3.创建实现类对象
        4.创建线程对象，将实现类对象传递给线程对象
        5.启动线程
 */
public class MyRunnable implements Runnable{
    // 线程任务
    @Override
    public void run() {
        for(int i = 1; i <= 20; i++) {
            System.out.println(Thread.currentThread().getName() + "...." + i);
        }
    }
}
