package com.bjpowernode.jdbc2;
import com.bjpowernode.jdbc.JdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
    JDBC事务控制，依赖的对象是 Connection
	void setAutoCommit​(boolean autoCommit) 将此连接的自动提交模式设置为给定状态。 false
	void commit​() 使上次提交/回滚之后所做的所有更改都将永久性，并释放此 Connection对象当前持有的任何数据库锁。
	void rollback​() 撤消在当前事务中所做的所有更改，并释放此 Connection对象当前持有的任何数据库锁。
*/
public class Demo09_JdbcTransaction {
    public static void main(String[] args) {
        // 声明对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // 注册驱动 获取连接
            connection = JdbcUtils.getConnection();
            // 开启事务
            connection.setAutoCommit(false);

            // 获取预编译对象
            String sql = "update account set money = money - 100 where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            // ?号赋值
            preparedStatement.setString(1,"a");
            // 执行SQL
            preparedStatement.executeUpdate();
            /////////////////////////////////////////////////////////////////////////
            // 异常
            System.out.println( 1 / 0 );

            // 获取预编译对象
            sql = "update account set money = money + 100 where name = ?";
            preparedStatement = connection.prepareStatement(sql);
            // ?号赋值
            preparedStatement.setString(1,"b");
            // 执行SQL
            preparedStatement.executeUpdate();

            // 提交事务
            connection.commit();

        }catch (Exception e) {
            // 事务回滚
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            // 释放资源
            JdbcUtils.close(preparedStatement, connection);
        }
    }
}
