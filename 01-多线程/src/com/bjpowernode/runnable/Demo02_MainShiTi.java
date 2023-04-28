package com.bjpowernode.runnable;
public class Demo02_MainShiTi  {
    public static void main(String[] args) {
        // 创建了Thread类的子类对象
        new Thread(){
            @Override
            public void run() {
                System.out.println("继承实现匿名线程...");
            }
        }.start();

        // 创建线程对象 传递线程任务
        new Thread( new Runnable(){
            @Override
            public void run() {
                System.out.println("实现类实现匿名线程....");
            }
        } ).start();

        // 面试题  继承的优先级高于实现的优先级
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("实现.....");
            }
        }){
            @Override
            public void run() {
                System.out.println("继承.....");
            }
        }.start();

        // 面试题
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("这是线程的任务...");
            }
            // 子类特有成员方法
            public void show() {
                System.out.println("show run....");
            }
        };
        thread.start();
        // thread.show();
    }
}
