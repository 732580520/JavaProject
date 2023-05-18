package com.bjpowernode.fanShe;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

/*
    java.lang.Class<T>:Class类的实例表示正在运行的Java应用程序中的类和接口。 枚举是一种类，注解是一种接口。
	    每个数组也属于一个类，它被反映为具有相同元素类型和维数的所有数组共享的Class对象。
	    原始Java类型 boolean byte char short int long float double 以及关键字 void 也表示为Class对象。
    获取类的Class对象
        1.使用对象的getClass()方法 ---> Object ---> Class<?> getClass​() 返回此 Object的运行时类。
        2.使用数据类型的class属性
        3.使用forName()方法  --> Class --> static Class<?> forName​(String className) 返回与给定字符串名称的类或接口相关联的 Class对象。
 */
public class Demo01_GetClass {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        // 使用对象的getClass()方法 ---> Object ---> Class<?> getClass​() 返回此 Object的运行时类。
        Student student = new Student();
        ArrayList<String> list = new ArrayList<>();
        int[] ints = new int[1];
        Class<? extends Student> aClass1 = student.getClass();
        System.out.println("aClass1 = " + aClass1);
        Class<? extends ArrayList> aClass2 = list.getClass();
        System.out.println("aClass2 = " + aClass2);
        Class<? extends int[]> aClass3 = ints.getClass();
        System.out.println("aClass3 = " + aClass3);

        // 使用数据类型的class属性
        Class<Student> aClass4 = Student.class;
        System.out.println("aClass4 = " + aClass4);
        Class<Integer> aClass5 = int.class;
        System.out.println("aClass5 = " + aClass5);
        Class<int[]> aClass6 = int[].class;
        System.out.println("aClass6 = " + aClass6);

        // 使用forName()方法  --> Class --> static Class<?> forName​(String className) 返回与给定字符串名称的类或接口相关联的 Class对象。
        Properties prop = new Properties();
        prop.load(new FileReader("prop.properties"));
        String className = prop.getProperty("className");

        Class<?> aClass7 = Class.forName(className);
        System.out.println("aClass7 = " + aClass7);
    }
}
