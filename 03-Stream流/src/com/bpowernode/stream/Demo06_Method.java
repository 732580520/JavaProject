package com.bpowernode.stream;

import java.util.ArrayList;
import java.util.Collections;

/*
    Stream成员方法'延迟方法：返回值还是Stream对象   终结方法：返回值不是Stream对象
        Stream<T> filter​(Predicate<? super T> predicate) 返回由与此给定谓词匹配的此流的元素组成的流。
        void forEach​(Consumer<? super T> action) 对此流的每个元素执行操作。
 */
public class Demo06_Method {
    public static void main(String[] args) {
        // 集合
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        // 获取偶数
        list.stream().filter(num -> num % 2 ==0).forEach(num -> System.out.println(num));

    }
}
