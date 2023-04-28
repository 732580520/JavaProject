package com.bjpowernode.thread;
/*
    创建线程的方式一:
        1.声明Thread子类
        2.子类重写run方法
        3.创建子类对象
        4.启动线程
 */
public class Demo01_MyThread {
    public static void main(String[] args) {
        // 创建子类线程对象
        MyThread thread = new MyThread();
        // 启动线程
        // thread.run();
        thread.start();

        // 创建新的线程对象
        MyThread thread1 = new MyThread();
        thread1.start();

        // main线程
        for(int i = 1; i <= 20; i++ ) {
            System.out.println("旺财...... " + i);
        }
    }
}
