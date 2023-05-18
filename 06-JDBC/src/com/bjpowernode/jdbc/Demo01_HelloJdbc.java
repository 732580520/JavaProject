package com.bjpowernode.jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
/*
    JDBC实现步骤:
        1.注册驱动
        2.获取连接
        3.获取发送SQL语句的对象
        4.发送SQL语句，返回结果
        5.处理结果
        6.释放资源
*/
public class Demo01_HelloJdbc {
    public static void main(String[] args) throws SQLException {
        // 声明对象
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // 注册驱动 获取连接
            connection = JdbcUtils.getConnection(); // 先运行一下
            // 获取发送SQL语句对象
            statement = connection.createStatement();
            // 发送SQL语句，返回结果
            String sql = "select * from person";
            resultSet = statement.executeQuery(sql);
            // 处理结果
            while (resultSet.next()) {
                // 获取数据
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String age = resultSet.getString("age");
                System.out.println(id + "..." + name + "..." + age);
            }
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            JdbcUtils.close(resultSet,statement,connection);
        }

    }
}
