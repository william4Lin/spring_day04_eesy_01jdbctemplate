package com.william.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * jdbcTemplate的最基本用法
 */
public class JdbcTemplateDemo1 {

    public static void main(String[] args) {

        //创建数据源,sprig的内置数据源
        DriverManagerDataSource dmds = new DriverManagerDataSource();

        dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dmds.setUrl("jdbc:mysql://localhost:3306/eesy?serverTimezone=UTC");
        dmds.setUsername("root");
        dmds.setPassword("123456");

        //创建对象
        JdbcTemplate jt = new JdbcTemplate();
        //关联数据源
        jt.setDataSource(dmds);
        //执行操作
        jt.execute("insert into account(id,name,money) values(5,'boss',2000)");


    }



}
