package com.bjpowernode.fanShe;
import java.lang.reflect.Method;
/*
    反射成员方法
        Method getMethod​(String name, Class<?>... parameterTypes) 返回一个 方法对象，该对象反映由该 Class对象表示的类或接口的指定'公共成员方法。
        Method[] getMethods​() 返回一个包含 方法对象的数组， 方法对象反映由该 Class对象表示的类或接口的'所有公共方法，包括由类或接口声明的对象以及从超类和超级接口继承的类。
        Method getDeclaredMethod​(String name, Class<?>... parameterTypes) 返回一个 方法对象，它反映此表示的类或接口的指定声明的方法 Class对象。
        Method[] getDeclaredMethods​() 返回一个包含 方法对象的数组， 方法对象反映由 Class对象表示的类或接口的所有声明方法，包括public，protected，default（package）访问和私有方法，但不包括继承方法
 */
public class Demo04_GetMethod {
    public static void main(String[] args) throws Exception {
        // 获取Class对象
        Class<?> aClass = Class.forName("com.bjpowernode.fanShe.Student");
        // 获取所有方法对象
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        // 创建对象
        Object s = aClass.getConstructor().newInstance();
        System.out.println("s = " + s);

        // 获取setName方法
        Method setName = aClass.getMethod("setName", String.class);
        Object setNameValue = setName.invoke(s, "米尔康");
        System.out.println("setNameValue = " + setNameValue);
        System.out.println("s = " + s);

        // 获取getName方法
        Method getName = aClass.getMethod("getName");
        Object getNameValue = getName.invoke(s);
        System.out.println("getNameValue = " + getNameValue);

        // 获取私有静态方法sleep
        Method sleep = aClass.getDeclaredMethod("sleep");
        // 抑制访问权限
        sleep.setAccessible(true);
        // 运行方法
        Object sleepValue = sleep.invoke(null);
        System.out.println("sleepValue = " + sleepValue);
    }
}
