package com.bjpowernode.jdbc2;

import com.bjpowernode.jdbc.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Demo04_Update {
    public static void main(String[] args) {
        // 声明对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // 注册驱动 获取连接
            connection = JdbcUtils.getConnection();
            // 获取预编译对象
            String sql = "update person set name = '卖烧饼的' where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            // ?号赋值
            preparedStatement.setString(1,"大朗");
            // 执行SQL语句
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
