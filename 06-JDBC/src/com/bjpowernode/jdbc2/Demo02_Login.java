package com.bjpowernode.jdbc2;

import com.bjpowernode.jdbc.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/*
    用户的信息是保存在数据库的数据表中，当用户输入完账号和密码之后，查询数据库，查看账号密码是否存在
    预编译实现步骤：
        1.注册驱动
        2.获取连接
        3.传递SQL语句框架 获取预编译对象
        4.给?号赋值
        5.执行SQL语句 返回结果
        6.处理结果
        7.释放资源
*/
public class Demo02_Login {
    public static void main(String[] args) {
        // 创建键盘录入
        Scanner input = new Scanner(System.in);
        System.out.print("请输入账号：");
        String username = input.nextLine();
        System.out.print("请输入密码：");
        String password = input.nextLine();
        boolean login = checkLogin(username, password);
        System.out.println(login ? "登录成功" : "登录失败");

    }
    private static boolean checkLogin(String username, String password) {
        // 声明对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;// 预编译对象
        ResultSet resultSet = null;
        try {
            // 注册驱动 获取连接
            connection = JdbcUtils.getConnection();
            // 获取预编译对象
            String sql = "select * from user where username = ? and password = ?";
            preparedStatement = connection.prepareStatement(sql);
            // 给?号赋值
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            // 执行SQL 语句
            resultSet = preparedStatement.executeQuery();
            // 处理结果
            if(resultSet.next()) {
                return true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 释放资源
            JdbcUtils.close(resultSet, preparedStatement, connection);
        }
        // 账号不存在
        return false;
    }
}
