package com.bjpowernode.jdbc2;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DruidUtils {
    private static DataSource ds;
    // 注册驱动 创建连接池对象
    static {
        try {
            Properties prop = new Properties();
            prop.load(new FileReader("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 返回连接池对象的方法
    public static DataSource getDs() {
        return ds;
    }
    // 获取连接对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
    // 释放资源
    public static void close(Statement statement , Connection connection) {
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
