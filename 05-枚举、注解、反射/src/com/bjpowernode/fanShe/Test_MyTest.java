package com.bjpowernode.fanShe;

import java.lang.reflect.Method;

public class Test_MyTest {
    public static void main(String[] args) throws Exception {
        // 让MyJunit类中，带MyTest注解的方法 运行
        // 1.获取MyJunit类中的所有成员方法
        Class<?> aClass = Class.forName("com.bjpowernode.fanShe.MyJunit");
        Object o = aClass.getConstructor().newInstance();
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            // 2.判断方法上是否存在注解
            if(method.isAnnotationPresent(MyTest.class)) {
                // 3.运行方法
                method.invoke(o);
            }
        }
    }
}
