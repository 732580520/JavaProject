package com.bpowernode.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

/*
    1. 首先筛选所有姓张的人；
    2. 然后筛选姓张名字有三个字的人；
    3. 最后进行对结果进行打印输出。
 */
public class Demo01_Stream {
    public static void main(String[] args) {
        // 声明集合
        ArrayList<String> list = new ArrayList<>();
        // 给集合中添加数据
        Collections.addAll(list, "张三丰", "张无忌", "张翠山", "张三","赵敏","周芷若");
        // 1. 首先筛选所有姓张的人；
        ArrayList<String> a = new ArrayList<>();
        for (String name : list) {
            if(name.startsWith("张")){
                a.add(name);
            }
        }
        // 2. 然后筛选姓张名字有三个字的人；
        ArrayList<String> b = new ArrayList<>();
        for (String name : a) {
            if(name.length() == 3) {
                b.add(name);
            }
        }
        // 3. 最后进行对结果进行打印输出。
        for (String name : b) {
            System.out.println(name);
        }
        System.out.println("==================================================");

        Stream<String> stream = list.stream();
        Stream<String> stream1 = stream.filter(name -> name.startsWith("张"));
        Stream<String> stream2 = stream1.filter(name -> name.length() == 3);
        stream2.forEach(name -> System.out.println(name));
        //list.stream().filter(name -> name.startsWith("张")).filter(name -> name.length() == 3).forEach(name -> System.out.println(name));
    }
}
