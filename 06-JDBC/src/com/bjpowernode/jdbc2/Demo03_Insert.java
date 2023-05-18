package com.bjpowernode.jdbc2;

import com.bjpowernode.jdbc.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Demo03_Insert {
    public static void main(String[] args) {
        // 声明对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // 注册驱动 获取连接
            connection = JdbcUtils.getConnection();
            // 获取预编译对象
            String sql = "insert into person values(null,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            // ?号赋值
            preparedStatement.setString(1,"大朗");
            preparedStatement.setInt(2, 18);
            // 执行SQL 返回结果
            int count = preparedStatement.executeUpdate();
            // 处理结果
            System.out.println("count = " + count);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 释放资源
            JdbcUtils.close(preparedStatement, connection);
        }


    }
}
