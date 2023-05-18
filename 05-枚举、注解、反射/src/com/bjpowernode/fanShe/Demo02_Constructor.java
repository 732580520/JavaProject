package com.bjpowernode.fanShe;

import java.lang.reflect.Constructor;
/*
    Constructor<T> getConstructor​(Class<?>... parameterTypes) 返回一个 Constructor对象，该对象反映由该 Class对象表示的类的指定'公共构造函数。
	Constructor<?>[] getConstructors​() 返回一个包含 Constructor对象的数组， Constructor对象反映了由该 Class对象表示的类的所有'公共构造函数。
	Constructor<T> getDeclaredConstructor​(Class<?>... parameterTypes) 返回一个 Constructor对象，该对象反映由此 Class对象表示的类或接口的指定构造函数。
	Constructor<?>[] getDeclaredConstructors​() 返回反映由该 Class对象表示的类声明的所有构造函数的 Constructor对象的数组。
 */
public class Demo02_Constructor {
    public static void main(String[] args) throws Exception {
        // 获取类的Class对象
        Class<?> aClass = Class.forName("com.bjpowernode.fanShe.Student");
        // 获取类构造方法对象
        Constructor<?>[] cons = aClass.getDeclaredConstructors();
        for (Constructor<?> con : cons) {
            System.out.println(con);
        }
        // 获取给name和age赋值的构造方法
        Constructor<?> name_age = aClass.getConstructor(String.class, int.class);
        // 通过构造方法对象，创建Student类的实例对象
        Student s1 = (Student)name_age.newInstance("伍成龙", 28);
        System.out.println("s1 = " + s1);

        // 获取私有给name赋值的构造方法对象
        Constructor<?> nameCon = aClass.getDeclaredConstructor(String.class);
        // 抑制访问权限
        nameCon.setAccessible(true);
        Object s2 = nameCon.newInstance("王顺龙");
        System.out.println("s2 = " + s2);

        // 获取默认给age赋值的构造方法
        Constructor<?> intCon = aClass.getDeclaredConstructor(int.class);
        Object s3 = intCon.newInstance(18);
        System.out.println("s3 = " + s3);
    }
}
