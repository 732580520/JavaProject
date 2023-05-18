package com.bjpowernode.jdbc2;

import com.bjpowernode.jdbc.JdbcUtils;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Random;

/*
    批处理：将一批次的SQL语句，同时执行。
    步骤：
        1.添加批处理列表
        2.执行批处理列表
        3.清空批处理列表

    Statement对象:
        void addBatch​(String sql) 将给定的SQL命令添加到此Statement对象的当前命令列表中。
        int[] executeBatch​() 将一批命令提交到数据库以执行，并且所有命令都执行成功，返回一个更新计数的数组。
        void clearBatch​() 清空这个 Statement对象当前的SQL命令列表。
 */
public class Demo07_StatementBatch {
    public static void main(String[] args) {
        // 声明对象
        Connection connection = null;
        Statement statement = null;
        try {
            // 注册驱动 获取连接
            connection = JdbcUtils.getConnection();
            // 获取Statement对象
            statement = connection.createStatement();
            // 添加批处理列表
            for(int i = 1; i <= 100; i++) {
                String sql = "insert into person values(null,'张某某','" + new Random().nextInt(50) + "')";
                statement.addBatch(sql);
            }
            // 执行批处理列表
            int[] ints = statement.executeBatch();
            for (int anInt : ints) {
                System.out.println(anInt);
            }
            // 清空批处理列表
            statement.clearBatch();
            // 处理结果
            System.out.println(ints.length);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 释放资源
            JdbcUtils.close(statement, connection);
        }
    }
}
