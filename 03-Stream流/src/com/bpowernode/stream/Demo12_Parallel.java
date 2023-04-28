package com.bpowernode.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class Demo12_Parallel {
    public static void main(String[] args) {
        // 创建集合
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        // 普通打印流中的数据
        // list.stream().forEach(num -> System.out.println(Thread.currentThread().getName() + ".." + num));
        // 并发流
        // list.parallelStream().forEach(num -> System.out.println(Thread.currentThread().getName() + "....." + num));

        // 创建数组
        Integer[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // 转化为并发流
        Arrays.stream(integers).parallel().forEach(num -> System.out.println(Thread.currentThread().getName() + "....." + num));
    }
}
