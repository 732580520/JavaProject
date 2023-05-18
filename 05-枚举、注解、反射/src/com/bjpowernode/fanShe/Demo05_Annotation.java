package com.bjpowernode.fanShe;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
    注解的反射：
        1.获取类的Class对象
        2.获取类的成员对象
        3.判断类的成员上是否存在指定的注解
        4.获取注解对象
        5.通过注解的对象 访问注解的成员变量
 */

public class Demo05_Annotation {
    @Test
    public void method() throws Exception {
        // 1.获取类的Class对象
        Class<?> aClass = Class.forName("com.bjpowernode.fanShe.Student");
        // 2.获取类的成员对象
        Method setName = aClass.getMethod("setName", String.class);
        // 3.判断类的成员上是否存在指定的注解
        if(setName.isAnnotationPresent(MyAnno.class)) {
            // 4.获取注解对象
            MyAnno anno = setName.getAnnotation(MyAnno.class);
            // 5.通过注解的对象 访问注解的成员变量
            String name = anno.name();
            System.out.println("name = " + name);
            // 创建对象
            Object o = aClass.getConstructor().newInstance();
            setName.invoke(o,name);
            System.out.println("o = " + o);
        }
    }


    @Test
    public void filed() throws Exception {
        // 1.获取类的Class对象
        Class<?> aClass = Class.forName("com.bjpowernode.fanShe.Student");
        // 2.获取类的成员对象
        Field name = aClass.getField("name");
        // 3.判断类的成员上是否存在指定的注解
        if(name.isAnnotationPresent(MyAnno.class)) {
            // 4.获取注解对象
            MyAnno anno = name.getAnnotation(MyAnno.class);
            // 5.通过注解的对象 访问注解的成员变量
            String nameValue = anno.name();
            System.out.println("nameValue = " + nameValue);
            // 创建对象
            Object o = aClass.getConstructor().newInstance();
            name.set(o,nameValue);
            System.out.println("o = " + o);
        }
    }

    @Test
    public void constructor() throws Exception {
        // 1.获取类的Class对象
        Class<?> aClass = Class.forName("com.bjpowernode.fanShe.Student");
        // 2.获取类的成员对象
        Constructor<?> con = aClass.getDeclaredConstructor(String.class);
        // 抑制访问权限
        con.setAccessible(true);

        // 3.判断类的成员上是否存在指定的注解
        if(con.isAnnotationPresent(MyAnno.class)) {
            // 4.获取注解对象
            MyAnno anno = con.getAnnotation(MyAnno.class);
            String name = anno.name();
            System.out.println("name = " + name);
            // 创建实例对象
            Object s = con.newInstance(name);
            System.out.println("s = " + s);
        }
    }
}
