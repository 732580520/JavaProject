package com.bpowernode.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/*
    1. 第一个队伍只要名字为3个字的成员姓名；
    2. 第一个队伍筛选之后只要前3个人；
    3. 第二个队伍只要姓张的成员姓名；
    4. 第二个队伍筛选之后不要前2个人；
    5. 将两个队伍合并为一个队伍；
    6. 根据姓名创建 Person 对象；
    7. 打印整个队伍的Person对象信息。
 */
public class Test {
    public static void main(String[] args) {

        List<String> one = new ArrayList<>();
        Collections.addAll(one,"迪丽热巴","宋远桥","苏星河","老子","庄子","孙子","洪七公");

        List<String> two = new ArrayList<>();
        Collections.addAll(two,"古力娜扎","张无忌","张三丰","赵丽颖","张二狗","张天爱","张三");

        //1. 第一个队伍只要名字为3个字的成员姓名；
        List<String> oneA = new ArrayList<>();
        for (String s : one) {
            if(s.length() == 3) {
                oneA.add(s);
            }
        }
        //2. 第一个队伍筛选之后只要前3个人；
        List<String> oneB = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            oneB.add(oneA.get(i));
        }
        //3. 第二个队伍只要姓张的成员姓名；
        List<String> twoA = new ArrayList<>();
        for (String s : two) {
            if(s.startsWith("张")) {
                twoA.add(s);
            }
        }
        //4. 第二个队伍筛选之后不要前2个人；
        List<String> twoB = new ArrayList<>();
        for(int i = 2; i < twoA.size(); i++) {
            twoB.add(twoA.get(i));
        }
        //5. 将两个队伍合并为一个队伍；
        List<String> ab = new ArrayList<>();
        ab.addAll(oneB);
        ab.addAll(twoB);
        //6. 根据姓名创建 Person 对象；
        List<Person> people = new ArrayList<>();
        for (String s : ab) {
            Person person = new Person(s);
            people.add(person);
        }
        //7. 打印整个队伍的Person对象信息。
        for (Person person : people) {
            System.out.println(person);
        }
        System.out.println("==================================");

        Stream.concat(
                one.stream().filter(s -> s.length() == 3).limit(3),
                two.stream().filter(s -> s.startsWith("张")).skip(2)
        ).map(s -> new Person(s)).forEach(p -> System.out.println(p));

        System.out.println("=======================================");
        /*
            方法引用：方法被调用，那么方法能被谁调用? 对象、类或接口、this、super、new
            优化Lambda表达式   语法符号：::
            1.Lambda必须有且仅有一个参数
            2.Lambda表达式中在调用某一个方法，并且在通过当前方法处理这个唯一的参数
        */
        Stream.concat(
                one.stream().filter(s -> s.length() == 3).limit(3),
                two.stream().filter(s -> s.startsWith("张")).skip(2)
        ).map( Person::new ).forEach( System.out::println );
    }
}
