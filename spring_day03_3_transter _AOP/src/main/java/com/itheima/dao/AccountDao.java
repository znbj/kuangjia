package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

public interface AccountDao {
    /**
     *
     * @return
     */
    public List<Account> selectAll();

    Account findByName(String fromName);

    void update(Account fromAccount);
}
