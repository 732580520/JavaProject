package com.bjpowernode.junit;

public class Demo_ArrayUtils {
    public static void main(String[] args) {
        // 数组
        int[] ints = {1, 2, 3, 4, 5};
        // 创建对象
        ArrayUtils au = new ArrayUtils();
        int sum = au.getSum(ints);
        System.out.println("sum = " + sum);
    }
}
