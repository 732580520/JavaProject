package com.bjpowernode.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Demo02_Comparator {
    public static void main(String[] args) {
        // 集合
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 3, 2, 4, 5, 7, 9, 8, 6);
        // 升序
        Collections.sort(list);
        System.out.println(list);
        // 降序
        // Collections.reverse(list);
        /*Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });*/
        // Collections.sort(list,(Integer o1, Integer o2)->{ return o2 - o1;});
        Collections.sort(list,(o1,o2)->  o2 - o1);
        System.out.println(list);


        // 创建数组 保存数据
        String[] strings = {"伍成龙", "包明树", "徐航", "宋利", "刘佳正", "祥子"};
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println(Arrays.toString(strings));

        // 长度降序
        //Arrays.sort(strings,(String o1, String o2)->{ return o2.length() - o1.length();});
        Arrays.sort(strings,(o1, o2)-> o2.length() - o1.length());
        System.out.println(Arrays.toString(strings));
    }
}
