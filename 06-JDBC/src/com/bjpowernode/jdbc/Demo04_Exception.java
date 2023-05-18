package com.bjpowernode.jdbc;
import java.sql.*;
public class Demo04_Exception {
    public static void main(String[] args) {
        // 声明对象
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // 注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 获取连接
            String url = "jdbc:mysql://localhost:3306/sh2303?characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
            String user = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, user, password);
            // 获取Statement对象
            statement = connection.createStatement();
            // 发送SQL语句
            String sql = "select * from person";
            resultSet = statement.executeQuery(sql);
            // 处理结果
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if(resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
