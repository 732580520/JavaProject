package com.bpowernode.stream;

import java.sql.SQLOutput;
import java.util.Random;
import java.util.stream.Stream;

/*
    Stream<T> distinct​() 返回由该流的不同元素（根据 Object.equals(Object) ）组成的流。
    static <T> Stream<T> generate​(Supplier<? extends T> s) 返回无限顺序无序流，其中每个元素由提供的 Supplier 生成。
*/
public class Demo09_Method {
    public static void main(String[] args) {
        // 统计流中的元素个数
        long count = Stream.of(1, 2, 3, 4, 2, 2, 3, 4).count();
        System.out.println("count = " + count);
        // 排重统计个数
        long count1 = Stream.of(1, 2, 3, 4, 2, 2, 3, 4).distinct().count();
        System.out.println("count1 = " + count1);
        Stream.of(1, 2, 3, 4, 2, 2, 3, 4).distinct().forEach(num -> System.out.println(num));

        // 无限顺序无序流
        //Stream.generate(() -> "Hello World!").forEach(value -> System.out.println(value));
        Stream.generate(() -> new Random().nextInt(100)).skip(100).limit(20).forEach(value -> System.out.println(value));



    }
}
