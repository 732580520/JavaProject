package com.bpowernode.stream;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
    boolean allMatch​(Predicate<? super T> predicate) 返回此流的所有元素是否与提供的谓词匹配。
	boolean anyMatch​(Predicate<? super T> predicate) 返回此流的任何元素是否与提供的谓词匹配。
	boolean noneMatch​(Predicate<? super T> predicate) 返回此流的元素是否与提供的谓词匹配。
	default Stream<T> takeWhile​(Predicate<? super T> predicate) 如果此流被排序，则返回一个流，该流由与此给定谓词匹配的从该流获取的元素的最长前缀组成。
	default Stream<T> dropWhile​(Predicate<? super T> predicate) 如果此流被排序，则返回一个流，该流包含该流的剩余元素，在丢弃与给定谓词匹配的元素的最长前缀之后。

 */
public class Demo11_Method {
    public static void main(String[] args) {
        // 创建数组
        int[] ints = {2, 4, 2, 4, 6, 8, 1, 3, 5, 7};
        // 判断流中的数据是否全部满足判断的条件
        boolean allMatch = Arrays.stream(ints).allMatch(num -> num % 2 == 0);
        System.out.println("allMatch = " + allMatch);
        // 判断流中是否有元素满足判断条件
        boolean anyMatch = Arrays.stream(ints).anyMatch(num -> num % 2 == 0);
        System.out.println("anyMatch = " + anyMatch);
        // 判断流中的数据是否全部不满足判断的条件
        boolean noneMatch = Arrays.stream(ints).noneMatch(num -> num % 2 == 0);
        System.out.println("noneMatch = " + noneMatch);

        System.out.println("================================================");

        // dropWhile 根据条件循环删除流中满足条件的数据，直到遇到第一个不满足条件的数据开始，停止删除
        Arrays.stream(ints).dropWhile(num -> num % 2 == 0).forEach(num -> System.out.println(num));

        // takeWhile 根据条件循环保留流中满足条件的数据，直到遇到第一个不满足条件的数据开始，删除后续所有
        Arrays.stream(ints).takeWhile(num -> num % 2 == 0).forEach(num -> System.out.println(num));

    }
}
