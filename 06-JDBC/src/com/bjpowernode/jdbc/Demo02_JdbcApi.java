package com.bjpowernode.jdbc;


import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class Demo02_JdbcApi {
    public static void main(String[] args) throws Exception {
        // 属性集解决硬编码问题
        Properties prop = new Properties();
        prop.load(new FileReader("jdbc.properties"));
        String driverClass = prop.getProperty("driverClass");
        // 注册驱动
        // DriverManager.registerDriver(new Driver());
        Class.forName(driverClass);
        // 获取连接
        /*
            协议：协议，网络协议的简称，网络协议是通信计算机双方必须共同遵从的一组约定。
                如怎么样建立连接、怎么样互相识别等。只有遵守这个约定，计算机之间才能相互通信交流。
            jdbc:jdbc协议
            mysql:jdbc下mysql子协议
            localhost:数据库服务器的IP地址
            3306:端口号 理解为一个程序的编号
            sh2303:连接的数据仓库
            characterEncoding=utf8:设置编码格式  默认utf-8    可以省略
            useSSL=false:加密方法 false表示不加密
            serverTimezone=UTC:时区
        */
        String url = "jdbc:mysql://localhost:3306/sh2303?characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url,user,password );
        // 获取Statement对象
        Statement statement = connection.createStatement();
        // 执行SQL语句
        /*String sql = "insert into person(id,name,age)values(null,'和珅',25),(null,'秦桧',27),(null,'赵高',35),(null,'魏忠贤',68);";
        int count = statement.executeUpdate(sql);
        System.out.println("count = " + count);*/
        String sql = "select * from person";
        ResultSet resultSet = statement.executeQuery(sql);
        // 处理结果集
        ArrayList<Person> list = new ArrayList<>();
        while (resultSet.next()) {
            // 获取数据
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            // 创建Person对象
            Person person = new Person(id,name,age);
            list.add(person);
        }
        // 遍历集合
        list.forEach(person -> System.out.println(person));
        // 释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
