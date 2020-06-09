package com.william.dao.impl;

import com.william.dao.IAccountDao;
import com.william.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

/**
 * 账户持久层的实现类
 */
public class AccountDaoImpl extends JdbcDaoSupport  implements IAccountDao {
    /*private JdbcTemplate jt;

    public void setJt(JdbcTemplate jt) {
        this.jt = jt;
    }*/

    public Account findById(Integer id) {
        List<Account> account = getJt().query("select * from account where id = ?",new BeanPropertyRowMapper<Account>(Account.class),id);
        return account.isEmpty()?null:account.get(0);
    }

    public Account findByName(String name) {
        List<Account> accounts = getJt().query("select * from account where name = ?",new BeanPropertyRowMapper<Account>(Account.class),name);
        if(accounts.isEmpty()){
            return null;
        }else if(accounts.size()>1){
            throw new RuntimeException("结果集不唯一");
        }else{
            return accounts.get(0);
        }

    }

    public void updateAccount(Account account) {
        getJt().update("update account set name = ? ,money = ? where id = ?",account.getName(),account.getMoney(),account.getId());

    }
}
