package com.bpowernode.stream;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/*
    将流中的数据收集到集合中
	<R,A> R collect​(Collector<? super T,A,R> collector) 使用 Collector对此流的元素执行 mutable reduction操作。
		Collector：收集器对象 --> Collectors 收集器对象工厂类 --> toList​() | toSet​()
 */
public class Demo13_GetValueToCollecion {
    public static void main(String[] args) {
        // 创建流对象将偶数返回到集合中
        List<Integer> list = Stream.of(1, 2, 3, 4, 2, 2, 3, 4).filter(num -> num % 2 == 0).collect(Collectors.toList());
        System.out.println("list = " + list);

        Set<Integer> set = Stream.of(1, 2, 3, 4, 2, 2, 3, 4).filter(num -> num % 2 == 0).collect(Collectors.toSet());
        System.out.println("set = " + set);
    }
}
