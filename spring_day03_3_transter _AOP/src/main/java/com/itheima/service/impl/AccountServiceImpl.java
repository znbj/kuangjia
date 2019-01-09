package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDao accountDao;

    @Override
    public List<Account> selectAll() {
        return null;
    }

    @Override
    public void transfer(String fromName, String toName, Float money) {

            Account fromAccount=accountDao.findByName(fromName);
            fromAccount.setMoney(fromAccount.getMoney()-money);
            accountDao.update(fromAccount);

            //System.out.println(1/0);

            Account toAccount=accountDao.findByName(toName);
            toAccount.setMoney(toAccount.getMoney()+money);
            accountDao.update(toAccount);


    }
}
