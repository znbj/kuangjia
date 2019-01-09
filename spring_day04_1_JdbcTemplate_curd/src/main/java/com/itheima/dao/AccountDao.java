package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

public interface AccountDao {
    public List<Account> selectAll();

    public Account findById(Integer id);

    public void save(Account account);

    public void update(Account account);

    public void del(Integer id);

    public Account findByName(String name);

    public Integer findTotal();
}
