package com.bjpowernode.synchronized_;

public class DieLock implements Runnable {
    // 两个锁对象
    private Object lockA = new Object();
    private Object lockB = new Object();
    // 控制if语句的执行流程
    boolean flag = false;
    @Override
    public void run() {
        if( flag ) {
            // 线程1 执行if语句
            while (true) {
                synchronized (lockA) {
                    System.out.println("if lockA .....");
                    synchronized (lockB) {
                        System.out.println("if lockB....");
                    }
                }
            }
        } else {
            // 线程2 执行else语句
            while (true) {
                synchronized (lockB) {
                    System.out.println("else lockB .....");
                    synchronized (lockA) {
                        System.out.println("else lockA....");
                    }
                }
            }
        }
    }
}
