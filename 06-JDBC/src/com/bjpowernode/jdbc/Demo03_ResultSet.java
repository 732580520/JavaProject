package com.bjpowernode.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo03_ResultSet {
    public static void main(String[] args) throws Exception {
        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取连接
        String url = "jdbc:mysql://localhost:3306/sh2303?characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, user, password);
        // 获取Statement对象
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_UPDATABLE);
        // 发送SQL语句
        String sql = "select * from person";
        ResultSet resultSet = statement.executeQuery(sql);
        // 遍历结果集
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
        System.out.println("==============滚动结果集==============");
        while (resultSet.previous()) {
            System.out.println(resultSet.getString("name"));
            // 修改数据
            resultSet.updateInt("age",16);
            // void updateRow​() 使用此ResultSet对象的当前行的新内容更新底层数据库。
            resultSet.updateRow();
        }
        // 释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
