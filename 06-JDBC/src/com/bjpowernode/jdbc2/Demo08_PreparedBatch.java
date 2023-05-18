package com.bjpowernode.jdbc2;
import com.bjpowernode.jdbc.JdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;
/*
    批处理：将一批次的SQL语句，同时执行。
步骤：
	1.添加批处理列表
	2.执行批处理列表
	3.清空批处理列表
    PreparedStatement对象：
        void addBatch​() 向这个 PreparedStatement对象的一批命令添加一组参数。
        int[] executeBatch​() 将一批命令提交到数据库以执行，并且所有命令都执行成功，返回一个更新计数的数组。
        void clearBatch​() 清空这个 Statement对象当前的SQL命令列表。
 */
public class Demo08_PreparedBatch {
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
            // 添加批处理列表
            for(int i = 1; i <= 100; i++) {
                preparedStatement.setString(1,"李某某");
                preparedStatement.setInt(2,new Random().nextInt(100));
                preparedStatement.addBatch();
            }
            // 执行批处理列表
            preparedStatement.executeBatch();
            // 清空批处理列表
            preparedStatement.clearBatch();
        }catch (Exception e) {
             e.printStackTrace();
        }finally {
            // 释放资源
            JdbcUtils.close(preparedStatement, connection);
        }
    }
}
