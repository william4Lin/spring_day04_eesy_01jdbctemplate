package com.william.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 用于抽取dao实现类中的重复代码
 */
public class JdbcDaoSupport {
    private JdbcTemplate jt;

    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }

    public JdbcTemplate getJt() {
        return jt;
    }
    //private DataSource dataSource;

    public void setDataSource(DataSource dataSource){
        //this.dataSource = dataSource;
        if(jt == null){
            jt = createDataSource(dataSource);
        }
    }

    private JdbcTemplate createDataSource(DataSource dataSource){
            return new JdbcTemplate(dataSource);
    }
}
