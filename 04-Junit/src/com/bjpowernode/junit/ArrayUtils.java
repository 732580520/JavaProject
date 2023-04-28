package com.bjpowernode.junit;

public class ArrayUtils {
    // 数组求和
    public int getSum(int[] arr){
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
}
