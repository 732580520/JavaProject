package com.bjpowernode.lambda;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;
/*
    java.util.function.Predicate<T>:判断型接口，可以对数据实现条件的判断，返回判断的结果。
    抽象方法
        boolean test(T t) 在给定的参数上评估这个谓词。
 */
public class Demo04_Predicate {
    public static void main(String[] args) {
        // 创建集合
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        // 删除集合中的偶数  default boolean removeIf(Predicate<? super E> filter) 删除满足给定谓词的此集合的所有元素。
        list.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        });
        System.out.println(list);

        // Lambda表达式 删除奇数
        list.removeIf( num -> num % 2 != 0);
        System.out.println(list);
    }
}
