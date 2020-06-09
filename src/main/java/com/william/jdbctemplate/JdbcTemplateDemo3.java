package com.william.jdbctemplate;

import com.william.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * jdbcTemplate的CRUD
 */
public class JdbcTemplateDemo3 {

    public static void main(String[] args) {
        //创建容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = ac.getBean("jdbcTemplate",JdbcTemplate.class);
        //jt.execute("insert into account(id,name,money) values(6,'william',3333)");
        //保存
//        jt.update("insert into account(id,name,money) values(?,?,?)",7,"test",7777f);
        //更新
//        jt.update("update account set name = ?,money=? where id = ?","qqqq",5555f,5);
        //删除
//        jt.update("delete from account where id = ?",4);
        //查询全部
        /*List<Account> accounts = jt.query("select * from account" ,new BeanPropertyRowMapper<Account>(Account.class));
        for (Account account : accounts) {
            System.out.println(account);
        }*/
        //查询一个
        /*List<Account> account = jt.query("select * from account where id = ?" ,new BeanPropertyRowMapper<Account>(Account.class),1);
        System.out.println(account.isEmpty()?"查询无结果":account.get(0));*/
        //查询返回一行一列
        Long count = jt.queryForObject("select count(*) from account",Long.class);
        System.out.println(count);


    }



}
