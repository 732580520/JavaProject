package com.bjpowernode.lock;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Demo02_Executor {
    public static void main(String[] args) {
        // 创建线程池对象
        ExecutorService ex = Executors.newFixedThreadPool(2);
        // 创建线程任务对象
        Task task = new Task();
        // 执行任务
        ex.submit(task);
        ex.submit(task);
        ex.submit(task);
        // 关闭线程池
        ex.shutdown();

        // 创建线程池对象
        ExecutorService ex1 = Executors.newFixedThreadPool(2);
        // 执行任务
        ex1.submit(task);
        ex1.submit(task);
        ex1.submit(task);
        ex1.shutdown();
    }
}
