package com.bpowernode.stream;

import java.sql.SQLOutput;
import java.util.Arrays;

/*
    long count​() 返回此流中的元素数。
	Stream<T> limit​(long maxSize) 返回由此流的元素组成的流，截短长度不能超过 maxSize 。
	Stream<T> skip​(long n) 在丢弃流的第一个 n元素后，返回由该流的剩余元素组成的流。
 */
public class Demo07_Method {
    public static void main(String[] args) {
        // 数组
        String[] strings = {"a", "bb", "ccc", "dddd", "eeeee", "ffffff", "g", "h"};
        // 获取字符串长度>2
        long count = Arrays.stream(strings).filter(str -> str.length() > 2).count();
        System.out.println("count = " + count);

        Arrays.stream(strings).limit(0).forEach(str -> System.out.println(str));
        Arrays.stream(strings).skip(0).forEach(str -> System.out.println(str));

    }
}
