package com.bjpowernode.wait_notiry;
/*
    共享资源类
        1.提供容器
        2.提供给容器保存商品的方法
        3.提供从容器取出商品的方法
 */
public class Resource {
    // 共享资源容器
    private String[] strings = new String[1];
    // 记录商品的售卖情况
    int count = 1;
    // 锁
    private Object lock = new Object();

    // 保存商品
    public void set(String name) throws InterruptedException {
        synchronized (lock) {
            // 判断容器中是否有商品
            while (strings[0] != null) {
                // 生产者要等待
                lock.wait();
            }
            // 商品已经保存到容器中
            strings[0] = name + count;
            System.out.println(Thread.currentThread().getName() + "保存商品：" + strings[0]);
            // 模拟保存商品的时间
            //Thread.sleep(1);
            // 商品次数迭代
            count++;

            // 唤醒消费者
            lock.notifyAll();
        }
    }
    // 取出商品
    public void get() throws InterruptedException {
        synchronized (lock) {
            // 判断是否有商品
            while (strings[0] == null) {
                // 消费者等待
                lock.wait();
            }

            // 取出商品
            System.out.println(Thread.currentThread().getName() + "去除商品..............." + strings[0]);
            // 模拟取出商品的时间
            //Thread.sleep(1);
            // 容器迭代
            strings[0] = null;

            // 唤醒生产者
            lock.notifyAll();
        }
    }
}
