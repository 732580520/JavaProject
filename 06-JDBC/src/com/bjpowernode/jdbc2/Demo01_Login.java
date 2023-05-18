package com.bjpowernode.jdbc2;

import com.bjpowernode.jdbc.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/*
    用户的信息是保存在数据库的数据表中，当用户输入完账号和密码之后，查询数据库，查看账号密码是否存在
*/
public class Demo01_Login {
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
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // 注册驱动 获取连接
            connection = JdbcUtils.getConnection();
            // 获取Statement对象
            statement = connection.createStatement();
            // 发送SQL语句，返回结果
            String sql = "select * from user where username = '" + username + "'&& password = '" + password + "'";
            System.out.println("sql = " + sql);
            resultSet = statement.executeQuery(sql);
            // 处理结果
            if(resultSet.next()) {
                return true;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            // 释放资源
            JdbcUtils.close(resultSet, statement, connection);
        }
        // 账号不存在
        return false;
    }
}
