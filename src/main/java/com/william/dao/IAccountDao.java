package com.william.dao;

import com.william.domain.Account;

/**
 * 账户的持久层
 */
public interface IAccountDao {

    /**
     * 根据id查询账户
     * @param id
     * @return
     */
    Account findById(Integer id);

    /**
     * 根据名称查询账户
     * @param name
     * @return
     */
    Account findByName(String name);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);

}
