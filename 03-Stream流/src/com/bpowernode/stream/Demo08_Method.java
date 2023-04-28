package com.bpowernode.stream;

import java.io.Serializable;
import java.util.stream.Stream;

/*
    static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b) 合并ab两个流。
    <R> Stream<R> map(Function<? super T,? extends R> mapper) 返回由给定函数应用于此流的元素的结果组成的流。
 */
public class Demo08_Method {
    public static void main(String[] args) {
        // 创建流
        Stream<String> a = Stream.of("李志杰", "王顺龙", "徐航", "伍成龙");
        Stream<String> b = Stream.of("风流小王子", "风骚小公主", "续航里程", "成龙大哥");
        Stream<Integer> c = Stream.of(1, 2, 3, 4);
        // 合并流
        Stream<String> ab = Stream.concat(a, b);
        ab.forEach(str -> System.out.println(str));

        //Stream<? extends Serializable> ac = Stream.concat(a, c);

        // 将c流中的数据 转换为字符串
        c.map(num -> num + "").forEach(str -> System.out.println(str + 1));

    }
}
