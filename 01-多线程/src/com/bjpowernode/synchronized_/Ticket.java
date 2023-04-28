package com.bjpowernode.synchronized_;
/*
    线程安全：多线程操作共享数据，对共享资源的抢夺造成的数据安全问题。
    售票：
        1.窗口表示线程
        2.车票表示共享资源数据
    同步代码块
        synchronized(锁对象) { // 锁对象要求：任意且唯一
            操作共享资源的代码;
        }
 */
public class Ticket implements Runnable {
    // 车票
    private int num = 100;
    // 锁对象
    private Object lock = new Object();
    // 线程的任务就是售票
    @Override
    public void run() {
        // 窗口一直在工作
        while (true) {
            synchronized (this) {
                // 判断是否有车票
                if(num > 0) {
                    System.out.println(Thread.currentThread().getName() + "售票：" + num);
                    // 打印车票的时间
                    try {
                        Thread.sleep(1); // 锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 车票迭代
                    num--;
                }
            }
        }
    }

}
