package com.bpowernode.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;
/*
    获取Stream流对象
	集合：只有单列集合能够直接获取Stream对象，Map集合要转化为单列集合，然后在获取Stream对象。
		Collection ---> default Stream<E> stream() 返回一个序列Stream与此集合作为其来源。
	数组
		Arrays --->  static <T> Stream<T> stream(T[] array) 返回具有指定数组的序列Stream作为其来源。
 */
public class Demo05_GetStream {
    public static void main(String[] args) {
        //定义集合
        ArrayList<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        // 双列集合
        Map<String, Integer> map = new HashMap<>();
        Stream<Integer> stream2 = map.values().stream();
        Stream<String> stream3 = map.keySet().stream();
        Stream<Map.Entry<String, Integer>> stream4 = map.entrySet().stream();

        // 基本类型数组
        int[] ints = new int[1];
        IntStream intStream = Arrays.stream(ints);
        // 引用类型数组
        Integer[] integers = new Integer[1];
        Stream<Integer> stream5 = Arrays.stream(integers);

        // 通过数据获取Stream流对象
        Stream<Integer> stream6 = Stream.of(1, 2, 3, 4, 5);
    }
}
