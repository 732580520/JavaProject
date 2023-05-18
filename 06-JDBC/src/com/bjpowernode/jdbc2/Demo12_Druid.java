package com.bjpowernode.jdbc2;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.bjpowernode.jdbc.JdbcUtils;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class Demo12_Druid {
    public static void main(String[] args) {
        // 声明对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 获取连接对象
            connection = DruidUtils.getConnection();
            // 获取预编译对象
            String sql = "select * from account where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"a");
            // 发送SQL语句
            resultSet = preparedStatement.executeQuery();
            // 处理结果
            while (resultSet.next()) {
                System.out.println(resultSet.getString("money"));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 释放资源
            DruidUtils.close(resultSet, preparedStatement, connection);
        }
    }
}
