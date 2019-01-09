package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有
     * @return
     */
    public List<Account> findAll();
}
