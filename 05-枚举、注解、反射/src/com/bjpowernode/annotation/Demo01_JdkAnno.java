package com.bjpowernode.annotation;
/*
    JDK常用的注解:
        @overrid:声明在方法上，检测被注解的方法是否为重写的方法。
        @FunctionalInterface:声明在接口上,检测被注解的接口是否为函数式接口。
        @Deprecated:标记当前方法已经过时。
        @SuppressWarnings:抑制警告，让编译器不要报出警告信息。
*/
@FunctionalInterface() // 检测接口是否为函数式接口
@MyAnnotation(name = "李四", age = 22)
interface Inter {
    void show();
}
@MyAnnotation(name = "王五")
enum MyEnum {

}
@MyAnnotation(name = "张三")
class Fu {
    @Deprecated // 标记当前方法已经过时
    public void show() {
        System.out.println("Fu show ...");
    }
}
@SuppressWarnings(value = "all")
class Zi extends Fu {
    @MyAnnotation(name = "小孙")
    String name;
    @MyAnnotation(name = "小张")
    public Zi() {
    }

    @Override() //检测方法是否为重写方法
    public void show() {
        System.out.println("Zi show...");
    }
}
public class Demo01_JdkAnno {
    @MyAnnotation(name = "小吴")
    public static void main(/*@MyAnnotation(name="小刘")*/ String[] args ) {
        @SuppressWarnings(value = "unused")
        // @MyAnnotation(name="小陈")
        int num = 100;
    }
}
