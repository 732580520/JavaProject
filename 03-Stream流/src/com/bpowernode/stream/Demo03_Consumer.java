package com.bpowernode.stream;

import java.util.function.Consumer;

/*
    java.util.function.Consumer<T>:消费型接口。表示接受单个输入参数并且不返回结果的操作。
    抽象方法
        void accept​(T t) 对给定的参数执行此操作。
 */
public class Demo03_Consumer {
    public static void main(String[] args) {
        //匿名内部类
        accpetDemo(new Consumer<String>() {
            @Override
            public void accept(String s) {
                // 转换大写 输出
                String upperCase = s.toUpperCase();
                System.out.println("upperCase = " + upperCase);
            }
        }, "Hello");

        // Lambda
        accpetDemo(s -> System.out.println(s.toLowerCase()),"Hello");
    }
    public static void accpetDemo(Consumer<String> consumer,String str){
        consumer.accept(str);
    }
}
