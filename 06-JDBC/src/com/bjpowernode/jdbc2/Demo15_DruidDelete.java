package com.bjpowernode.jdbc2;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.bjpowernode.jdbc.JdbcUtils;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;
public class Demo15_DruidDelete {
    public static void main(String[] args) {
        // 声明对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // 获取连接对象
            connection = DruidUtils.getConnection();
            // 获取预编译对象
            String sql = "delete from account where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            // ?号赋值
            preparedStatement.setString(1,"王顺龙");
            // 执行
            int count = preparedStatement.executeUpdate();
            // 处理结果
            System.out.println("count = " + count);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 释放资源
            DruidUtils.close(preparedStatement, connection);
        }
    }
}
