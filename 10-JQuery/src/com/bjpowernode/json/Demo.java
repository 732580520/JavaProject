package com.bjpowernode.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/*
    JSON字符串：一种在各个编程语言中流通的标准的数据格式，负责不同编程语言中数据的交互和传递。
    语法格式:
        {"key1":value1,"key2":value2,"key3":value3}
        [
            {"key1":value1,"key2":value2,"key3":value3},
            {"key1":value1,"key2":value2,"key3":value3},
            {"key1":value1,"key2":value2,"key3":value3}
        ]
    key必须是字符串类型，value可以是任意类型。数据格式必须是key=value的情况下才能转换为JSON字符串。
*/
public class Demo {
    public static void main(String[] args) {
        // 创建User对象
        User user = new User(1, "小玄子", "紫禁城", new Date());
        System.out.println("user = " + user);
        // 将一个对象 转换为JSON字符串
        String userJson = JSON.toJSONString(user);
        System.out.println("userJson = " + userJson);

        // 创建字符串对象
        String str = "Hello World";
        String strJson = JSON.toJSONString(str);
        System.out.println("strJson = " + strJson);

        // 创建多个对象
        User u1 = new User(1,"伍成龙","上海",new Date());
        User u2 = new User(2,"王顺龙","北京",new Date());
        User u3 = new User(3, "李小龙", "深圳",new Date());
        // 将需要转换的数据 保存到集合中，之间转换集合
        List<User> users = Arrays.asList(u1, u2, u3);
        String usersJson = JSON.toJSONString(users);
        System.out.println("usersJson = " + usersJson);

        /////////////////////////////////////////////////////////////////////////////////////
        // 将json字符串转换为java对象
        User userObj = JSON.parseObject(userJson,User.class);
        System.out.println("userObj = " + userObj);
        // 将json字符串数组转换为java对象
        List<User> usersObj = JSON.parseArray(usersJson, User.class);
        System.out.println("usersObj = " + usersObj);


    }
}
