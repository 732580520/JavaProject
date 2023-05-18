package com.bjpowernode.fanShe;

import java.lang.reflect.Field;
/*
    反射成员变量
        Field getField​(String name) 返回一个 Field对象，该对象反映由该 Class对象表示的类或接口的指定'公共成员字段。
        Field[] getFields​() 返回一个包含 Field对象的数组， Field对象反映由该 Class对象表示的类或接口的所有可访问的'公共字段。
        Field getDeclaredField​(String name) 返回一个 Field对象，该对象反映由该 Class对象表示的类或接口的指定声明字段。
        Field[] getDeclaredFields​() 返回一个 Field对象的数组，反映了由该 Class对象表示的类或接口声明的所有字段。  返回一个 Field对象的数组，反映了由该 Class对象表示的类或接口声明的所有字段。
 */
public class Demo02_Filed {
    public static void main(String[] args) throws Exception {
        // 获取类的Class对象
        Class<?> aClass = Class.forName("com.bjpowernode.fanShe.Student");
        // 获取所有的成员变量对象
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        // 创建对象
        Object s = aClass.getConstructor().newInstance();
        System.out.println("s = " + s);
        // 获取公开name变量
        Field name = aClass.getField("name");
        // 给name赋值
        name.set(s,"张无忌");
        System.out.println("s = " + s);
        // 获取name的值
        Object nameValue = name.get(s);
        System.out.println("nameValue = " + nameValue);

        // 获取静态私有的变量 addr
        Field addr = aClass.getDeclaredField("addr");
        // 抑制访问权限
        addr.setAccessible(true);
        // 给addr赋值
        addr.set(null,"上海");
        // 获取addr的值
        Object addrValue = addr.get(null);
        System.out.println("addrValue = " + addrValue);
    }
}
