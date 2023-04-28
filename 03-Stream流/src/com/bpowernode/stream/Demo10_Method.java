package com.bpowernode.stream;
import java.util.ArrayList;
import java.util.Collections;
/*
    Optional<T> max​(Comparator<? super T> comparator) 根据提供的 Comparator返回此流的最大元素。
	Optional<T> min​(Comparator<? super T> comparator) 根据提供的 Comparator返回此流的最小元素。
	Stream<T> sorted​() 返回由此流的元素组成的流，根据自然顺序排序。
	Stream<T> sorted​(Comparator<? super T> comparator) 返回由该流的元素组成的流，根据提供的 Comparator进行排序。
 */
public class Demo10_Method {
    public static void main(String[] args) {
        // 创建集合
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "fasd", "adfsdfa", "gfdsgfhgfhdg", "ddfd", "a", "fgfsfgfdgs", "fgf", "fsdhfh", "sdfgsdfgfsg");
        // 获取最大长度 和 最小长度
        String max = list.stream().max((o1, o2) -> o1.length() - o2.length()).get();
        System.out.println("max = " + max);
        String min = list.stream().min((o1, o2) -> o1.length() - o2.length()).get();
        System.out.println("min = " + min);

        // 升序排序
        list.stream().sorted().forEach(str -> System.out.print(str + "   "));
        System.out.println();
        list.stream().sorted((o1,o2) -> o2.compareTo(o1)).forEach(str -> System.out.print(str + "   "));




    }
}
