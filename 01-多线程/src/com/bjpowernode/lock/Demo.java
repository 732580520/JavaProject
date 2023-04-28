package com.bjpowernode.lock;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        // 创建资源容器对象
        Resource resource = new Resource();
        // 创建生产者消费者线程任务对象
        Set set = new Set(resource);
        Get get = new Get(resource);

        // 创建生产者消费者线程对象
        Thread set_thread1 = new Thread(set,"生产者1");
        Thread set_thread2 = new Thread(set,"生产者2");
        Thread get_thread1 = new Thread(get,"消费者1");
        Thread get_thread2 = new Thread(get,"消费者2");
        // 启动线程
        set_thread1.start();
        set_thread2.start();

        get_thread1.start();
        get_thread2.start();
    }
}
