package com.bjpowernode.lambda;

public class Demo01_Runnable {
    public static void main(String[] args) {
        // 创建实现类对象
        MyRunnable mr = new MyRunnable();
        // 创建线程对象
        Thread thread = new Thread(mr);
        // 启动线程
        thread.start();

        // 匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名对象 传递线程任务.....");
            }
        }).start();

        // Lambda表达式 ()->{}
        new Thread( ()->{ System.out.println("Lambda表达式 启动线程...");} ).start();

        // Lambda表达式 省略格式
        new Thread( ()-> System.out.println("Lambda表达式 启动线程...") ).start();
    }
}
