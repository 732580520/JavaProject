package dao;


import bean.ATM;
import util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ATMDao {
    // 判断卡号是否存在
    public boolean checkCode(String code) {
        // 声明对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 注册驱动 获取连接
            connection = DBUtils.getConnection();
            // 获取预编译对象
            String sql = "select * from atm where atm_code = ?";
            preparedStatement = connection.prepareStatement(sql);
            // ?号赋值
            preparedStatement.setString(1, code);
            // 执行
            resultSet = preparedStatement.executeQuery();
            // 处理结果
            if (resultSet.next()) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            DBUtils.close(resultSet, preparedStatement, connection);
        }
        return false;
    }

    // 注册方法
    public boolean atmRegisterDao(ATM atm) {
        // 声明对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // 注册驱动 获取连接
            connection = DBUtils.getConnection();
            // 获取预编译对象
            String sql = "insert into atm value(null,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            // ？号赋值
            preparedStatement.setString(1, atm.getAtmCode());
            preparedStatement.setString(2, atm.getAtmPwd());
            preparedStatement.setString(3, atm.getAtmName());
            preparedStatement.setDouble(4, atm.getAtmMoney());
            // 执行
            int count = preparedStatement.executeUpdate();
            // 处理
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            DBUtils.close(preparedStatement, connection);
        }
        return false;
    }

    // 登录实现
    public ATM atmLoginDao(String atmCode, String atmPwd) {
        // 声明对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 注册驱动 获取连接
            connection = DBUtils.getConnection();
            // 获取预编译对象
            String sql = "select * from atm where atm_code = ? and atm_pwd = ?";
            preparedStatement = connection.prepareStatement(sql);
            // ？号赋值
            preparedStatement.setString(1, atmCode);
            preparedStatement.setString(2, atmPwd);
            // 执行
            resultSet = preparedStatement.executeQuery();
            // 处理结果
            if (resultSet.next()) {
                ATM atm = new ATM();
                atm.setAtmId(resultSet.getInt("atm_id"));
                atm.setAtmPwd(resultSet.getString("atm_pwd"));
                atm.setAtmName(resultSet.getString("atm_name"));
                atm.setAtmMoney(resultSet.getDouble("atm_money"));
                atm.setAtmCode(resultSet.getString("atm_code"));
                return atm;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            DBUtils.close(resultSet, preparedStatement, connection);
        }
        return null;
    }

    public boolean setMoneyDao(String atmCode, double money) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // 注册驱动 获取连接
            connection = DBUtils.getConnection();
            // 获取预编译对象
            String sql = "update atm set atm_money = atm_money+'" + money + "' where atm_code = ?";
            preparedStatement = connection.prepareStatement(sql);
            // ？号赋值
            preparedStatement.setString(1, atmCode);
            // 执行
            int count = preparedStatement.executeUpdate();
            // 处理
            if (count > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            DBUtils.close(preparedStatement, connection);
        }
        return false;
    }

    public double queryMoneyDao(String atmCode) {
        //声明对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //获取连接
            connection = DBUtils.getConnection();
            //获取预编译对象
            String sql = "select atm_money from atm where atm_code = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, atmCode);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getDouble("atm_money");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放资源
            DBUtils.close(resultSet, preparedStatement, connection);
        }
        return 0;
    }

    // 取款
    public boolean getMoney(String atmCode, double moeny) {
        // 判断金额是否足够
        if (queryMoneyDao(atmCode) < moeny) {
            return false;
        }
        // 声明对象
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // 注册驱动 获取连接
            connection = DBUtils.getConnection();
            // 获取预编译对象
            String sql = "update atm set atm_money = atm_money - '" + moeny + "' where atm_code = ?";
            preparedStatement = connection.prepareStatement(sql);
            // ?号赋值
            preparedStatement.setString(1, atmCode);
            // 执行
            int count = preparedStatement.executeUpdate();
            // 处理结果
            if (count > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            DBUtils.close(preparedStatement, connection);
        }
        return false;
    }

    public boolean transferDao(String atmCode, String transferCode, double money, double transmoney) {
        if (queryMoneyDao(atmCode) >= transmoney && !checkCode(transferCode)) {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            try {
                // 注册驱动 获取连接
                connection = DBUtils.getConnection();
                // 获取预编译对象
                String sql = "update atm set atm_money = atm_money - '" + transmoney + "' where atm_code = ?";

                preparedStatement = connection.prepareStatement(sql);
                // ?号赋值
                preparedStatement.setString(1, atmCode);
                // 执行
                int count = preparedStatement.executeUpdate();
                // 处理结果
                if (count > 0) {
                    String sql1 = "update atm set atm_money = atm_money + '" + transmoney + "' where atm_code = ?";
                    preparedStatement = connection.prepareStatement(sql1);
                    // ?号赋值
                    preparedStatement.setString(1, transferCode);
                    // 执行
                    count = preparedStatement.executeUpdate();
                    if (count > 0) {
                        return true;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 释放资源
                DBUtils.close(preparedStatement, connection);
            }
        }
        return false;
    }

    public boolean updatePwdDao(String atmCode, String atmPwd, String newPwd) {
        if (!atmPwd.equals(newPwd)) {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            try {
                // 注册驱动 获取连接
                connection = DBUtils.getConnection();
                // 获取预编译对象
                String sql = "update atm set atm_pwd = '" + newPwd + "' where atm_code = ?";
                preparedStatement = connection.prepareStatement(sql);
                // ?号赋值
                preparedStatement.setString(1, atmCode);
                // 执行
                int count = preparedStatement.executeUpdate();
                // 处理结果
                if (count > 0) {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 释放资源
                DBUtils.close(preparedStatement, connection);
            }
        }
        return false;
    }
}
