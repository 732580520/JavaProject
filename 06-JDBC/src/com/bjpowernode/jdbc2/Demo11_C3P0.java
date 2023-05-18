package com.bjpowernode.jdbc2;

import com.bjpowernode.jdbc.JdbcUtils;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo11_C3P0 {
    public static void main(String[] args) {
        // 声明对象
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // 注册驱动 创建连接池对象
            DataSource ds = new ComboPooledDataSource();
            // 获取连接对象
            connection = ds.getConnection();
            // 获取Statement对象
            statement = connection.createStatement();
            // 发送SQL语句
            String sql = "select * from account";
            resultSet = statement.executeQuery(sql);
            // 处理结果
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 释放资源
            JdbcUtils.close(resultSet, statement, connection);
        }
    }
}
