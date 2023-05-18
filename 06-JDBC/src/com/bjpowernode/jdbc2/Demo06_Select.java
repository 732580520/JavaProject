package com.bjpowernode.jdbc2;

import com.bjpowernode.jdbc.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo06_Select {
    public static void main(String[] args) {
        // 声明对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 注册驱动 获取连接
            connection = JdbcUtils.getConnection();
            // 获取预编译对象
            String sql = "select * from person where name like ?";
            preparedStatement = connection.prepareStatement(sql);
            // ?号赋值
            preparedStatement.setString(1,"%香%");
            // 执行sql
            resultSet = preparedStatement.executeQuery();
            // 处理结果
            while (resultSet.next() ) {
                System.out.println(resultSet.getString("name"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 释放资源
            JdbcUtils.close(resultSet, preparedStatement, connection);
        }
    }
}
