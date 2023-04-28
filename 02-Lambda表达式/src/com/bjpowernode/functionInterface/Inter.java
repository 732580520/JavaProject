package com.bjpowernode.functionInterface;
// 函数式接口:有且仅有一个'抽象方法'的接口。另外还要求当前这个接口必须作为某个方法的参数。

@FunctionalInterface // 检测接口是否为函数式接口
public interface Inter {
    // 抽象方法
    void show();
    // 默认方法
    default void show1() {
        System.out.println("默认方法...");
    }
    // 静态方法
    private static void show2() {
        System.out.println("静态方法...");
    }
}
