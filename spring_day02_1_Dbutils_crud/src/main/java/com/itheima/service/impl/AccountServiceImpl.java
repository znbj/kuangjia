package com.itheima.service.impl;

import com.itheima.service.AccountService;
import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    AccountDao accountDao;


    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> selectAll() {
        return accountDao.selectAll();
    }

    @Override
    public Account findById(Integer id) {
        return accountDao.findById(id);
    }
}
