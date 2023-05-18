package com.bpowernode.stream;

import java.util.function.Function;

/*
    java.util.function.Function<T,R>:转化型接口，表示接受一个参数并产生结果的函数。
    抽象方法
        R apply​(T t) 将此函数应用于给定的参数。
 */
public class Demo04_Function {
    public static void main(String[] args) {
        // 匿名内部类
        applyDemo(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.valueOf(s) + 123;
            }
        }, "123");

        // lambda
        applyDemo( s -> Integer.parseInt(s) + 123,"123");
    }
    public static void applyDemo(Function<String,Integer> function , String str) {
        Integer apply = function.apply(str);
        System.out.println("apply = " + apply);
    }
}
