package com.bpowernode.stream;
import java.util.Arrays;
import java.util.function.IntFunction;
import java.util.stream.Stream;
/*
    将流中的数据收集到数组中
        Object[] toArray​() 返回一个包含此流的元素的数组。
*/
public class Demo14_GetValueToArray {
    public static void main(String[] args) {
        // 将流中的数据 返回到数组中
        Object[] objects = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).filter(num -> num % 2 == 0).toArray();
        System.out.println(Arrays.toString(objects));

        // 将数据 返回到Integer数组
        Integer[] integers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).filter(num -> num % 2 == 0).toArray(new IntFunction<Integer[]>() {
            @Override
            public Integer[] apply(int value) { // value就是数组的长度
                return new Integer[value];
            }
        });
        System.out.println(Arrays.toString(integers));

        // Lambda 表达式
        Integer[] integers1 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).filter(num -> num % 2 == 0).toArray(value -> new Integer[value]);
        System.out.println(Arrays.toString(integers1));


    }
}
