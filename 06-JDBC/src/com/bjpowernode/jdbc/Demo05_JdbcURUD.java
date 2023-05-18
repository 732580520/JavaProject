package com.bjpowernode.jdbc;

import java.sql.*;
import java.util.Random;

public class Demo05_JdbcURUD {
    public static void main(String[] args) {
        insert();
        //  update();
        //delete();
    }
    // 添加数据
    public static void insert() {
        // 声明对象
        Connection connection = null;
        Statement statement = null;
        try {
            // 注册驱动 获取连接
            connection = JdbcUtils.getConnection();
            // 获取statement对象
            statement = connection.createStatement();
            // 发送SQL语句
            String sql = "insert into person values (null,'大朗',38),(null,'金莲',20),(null,'西门',58)";
            int count = statement.executeUpdate(sql);
            // 处理结果
            System.out.println("count = " + count);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(statement,connection);
        }
    }
    // 修改数据
    public static void update() {
        // 声明对象
        Connection connection = null;
        Statement statement = null;
        try {
            // 注册驱动 获取连接
            connection = JdbcUtils.getConnection();
            // 获取statement对象
            statement = connection.createStatement();
            // 发送SQL语句
            int age = new Random().nextInt(100);
            String sql = "update person set age = '" + age + "' where age = 65";
            int count = statement.executeUpdate(sql);
            // 处理结果
            System.out.println("count = " + count);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 释放资源
            JdbcUtils.close(statement,connection);
        }
    }
    // 删除数据
    public static void delete() {
        // 声明对象
        Connection connection = null;
        Statement statement = null;
        try {
            // 注册驱动  获取连接
            connection = JdbcUtils.getConnection();
            // 获取statement对象
            statement = connection.createStatement();
            // 发送SQL语句
            String sql = "delete from person where name in('大朗','金莲','西门')";
            int count = statement.executeUpdate(sql);
            // 处理结果
            System.out.println("count = " + count);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 释放资源
            JdbcUtils.close(statement,connection);
        }
    }
}
