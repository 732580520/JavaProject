package com.bjpowernode.jdbc2;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;
/*
    常用方法
        updae() 执行更新语句
        queryForMap() 执行查询语句，只能执行查询结果为一条的SQL语句，将结果返回到一个Map集合中，并且表的字段作为map集合的key 字段的值作为map集合的value
        queryForList() 执行查询语句，将结果返回到List集合中，集合中的每个数据都保存在一个Map集合中。
        queryForObject() 执行查询语句 ，一般结合聚合函数一起使用。
 */
public class Demo16_JdbcTemplate {
    // 创建操作数据库的模板对象
    private JdbcTemplate template = new JdbcTemplate(DruidUtils.getDs());
    @Test
    public void insert() {
        String sql = "insert into account values(null,?,?)";
        int count = template.update(sql, "伍成龙", 1.25);
        System.out.println("count = " + count);
    }
    @Test
    public void update() {
        String sql = "update account set money = 0.25 where name = ?";
        template.update(sql, "伍成龙");
    }

    @Test
    public void delete() {
        String sql = "delete from account where name = ?";
        template.update(sql, "伍成龙");
    }
    @Test
    public void query1() {
        String sql = "select * from account where id = ?";
        Map<String, Object> map = template.queryForMap(sql,1);
        System.out.println("map = " + map);
    }
    @Test
    public void query2() {
        String sql = "select * from account";
        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
    }
    @Test
    public void query3() {
        String sql = "select count(name) from person";
        /*Integer integer = template.queryForObject(sql, int.class);
        System.out.println("integer = " + integer);*/
        Long aLong = template.queryForObject(sql, long.class);
        System.out.println("aLong = " + aLong);
    }
}
