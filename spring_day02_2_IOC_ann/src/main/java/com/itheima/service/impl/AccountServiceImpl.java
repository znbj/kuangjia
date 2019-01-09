package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    AccountDao accountDao;
    @Override
    public void save(Account account) {
        accountDao.save(account);
    }
}
