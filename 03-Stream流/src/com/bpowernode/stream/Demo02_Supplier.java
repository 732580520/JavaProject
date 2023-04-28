package com.bpowernode.stream;

import java.util.function.Supplier;

/*
    java.util.function.Supplier<T>:生产型接口。代表结果供应商。
    抽象方法
        T get() 获得结果。
 */
public class Demo02_Supplier {
    public static void main(String[] args) {
        //匿名内部类
        getDemo(new Supplier<String>() {
            @Override
            public String get() {
                return "hello world";
            }
        });
        // lambda
        getDemo(()->{ return "HELLO WORLD";});
    }
    public static void getDemo(Supplier<String> supplier){
        String s = supplier.get();
        System.out.println("s = " + s);
    }
}
