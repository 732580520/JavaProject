package util;

import java.sql.*;

public class DBUtils {
    // 注册驱动
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    // 获取连接
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/sh2303?characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
    // 释放资源
    public static void close(AutoCloseable... acs) {
        for (AutoCloseable ac : acs) {
            if (ac != null) {
                try {
                    ac.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
