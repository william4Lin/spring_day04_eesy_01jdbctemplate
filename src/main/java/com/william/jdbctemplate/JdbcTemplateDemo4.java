package com.william.jdbctemplate;

import com.william.dao.IAccountDao;
import com.william.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * jdbcTemplate的最基本用法
 */
public class JdbcTemplateDemo4 {

    public static void main(String[] args) {
        //创建容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = ac.getBean("accountDao",IAccountDao.class);

        Account account = accountDao.findById(2);
        System.out.println(account);

        account.setMoney(22222f);
        accountDao.updateAccount(account);

        Account account1 = accountDao.findByName("aaa");
        System.out.println(account1);


    }



}
