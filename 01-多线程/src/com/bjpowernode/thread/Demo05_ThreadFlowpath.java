package com.bjpowernode.thread;
/*
    JVM对线程的切换是随机的，无法人为控制，但是可以控制执行中的线程对象。
        static void sleep(long millis) 使当前正在执行的线程停留（暂停执行）指定的毫秒数。
        static void sleep(long millis, int nanos) 导致正在执行的线程以指定的毫秒数加上指定的纳秒数来暂停（临时停止执行）。
        void join() 等待这个线程死亡。
        void join(long millis) 等待这个线程死亡 millis毫秒。
        void join(long millis, int nanos) 等待最多 millis毫秒加上这个线程死亡的 nanos纳秒。
 */
public class Demo05_ThreadFlowpath {
    public static void main(String[] args) throws InterruptedException {
        /*for(int i = 1; i <= 10; i++) {
            // 让线程暂停执行1000毫秒
            Thread.sleep(1000);
            System.out.println("第" + i + "秒!");
        }
        System.out.println("叮铃铃..时间到");*/

        // 创建3个线程对象
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        // 启动线程
        t1.start();
        // 等待t1死亡
        t1.join(10000);

        t2.start();
        t3.start();
    }
}
