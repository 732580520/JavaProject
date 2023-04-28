package com.bjpowernode.lock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
    java.util.concurrent.locks.Lock:专门负责代码的同步。
    成员方法
        void lock() 获得锁。
        void unlock() 释放锁。
	Lock l = ...;
	l.lock();
	try {
		// access the resource protected by this lock
	} finally {
		l.unlock()
	}
*/
public class Ticket implements Runnable {
    // 车票
    private int num = 100;
    // 锁
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true) {
            // 获取锁
            lock.lock();
            try {
                if (num > 0) {
                    System.out.println(Thread.currentThread().getName() + "售票：" + num);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    num--;
                }
            }finally {
                // 释放锁
                lock.unlock();
            }
        }
    }
}
