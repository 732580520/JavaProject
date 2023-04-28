package com.bjpowernode.synchronized_;

public class Ticket03 implements Runnable {
    // 车票
    private int num = 100;
    // 锁
    private Object lock = new Object();
    @Override
    public void run() {
        while (true) {
            try {
                ticket();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    // 定义方法，用于售票
    public /*synchronized*/ void ticket() throws InterruptedException {
        // 售票的代码是要求同步的
        synchronized (lock) {
            // 判断是否还有车票
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "售票：" + num);
                Thread.sleep(1);
                num--;
            }
        }
        // 伪代码 要求可以不用同步
        System.out.println("Hello World!");
        System.out.println("Hello World!");
        System.out.println("Hello World!");
        System.out.println("Hello World!");
        System.out.println("Hello World!");
        System.out.println("Hello World!");
        System.out.println("Hello World!");
        System.out.println("Hello World!");
    }
}
