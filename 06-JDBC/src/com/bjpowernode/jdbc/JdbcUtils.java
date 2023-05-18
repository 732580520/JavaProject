package com.bjpowernode.jdbc;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    // 创建属性集对象
    private static Properties prop = new Properties();
    // 注册驱动
    static {
        // 注册驱动
        try {
            prop.load(new FileReader("jdbc.properties"));
            String driverClass = prop.getProperty("driverClass");
            Class.forName(driverClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 获取连接
    public static Connection getConnection() throws Exception {
        String url = prop.getProperty("urlName");
        String user = prop.getProperty("userName");
        String password = prop.getProperty("passwordName");
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
    // 释放资源
    public static void close(Statement statement ,Connection connection) {
        // 释放资源
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
    // 释放资源
    public static void close(ResultSet resultSet , Statement statement , Connection connection) {
        // 释放资源
        if(resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // 调用上面释放资源的代码
        close(statement,connection);
    }
}
