package com.bjpowernode.synchronized_;

public class Ticket02 extends Thread {
    // 车票
    private static int num = 100;
    // 锁
    private static Object lock = new Object();
    //线程任务
    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                //判断
                if (num > 0) {
                    System.out.println(Thread.currentThread().getName() + "售票：" + num);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // 迭代车票
                    num--;
                }
            }
        }
    }
}
