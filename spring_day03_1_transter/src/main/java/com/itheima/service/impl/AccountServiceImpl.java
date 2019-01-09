package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import com.itheima.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDao accountDao;
    @Autowired
    TransactionManager tm;

    @Override
    public List<Account> selectAll() {
        return null;
    }

    @Override
    public void transfer(String fromName, String toName, Float money) {
        try {
            tm.beginTransaction();
            Account fromAccount=accountDao.findByName(fromName);
            fromAccount.setMoney(fromAccount.getMoney()-money);
            accountDao.update(fromAccount);



            Account toAccount=accountDao.findByName(toName);
            toAccount.setMoney(toAccount.getMoney()+money);
            accountDao.update(toAccount);
            tm.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tm.rollback();
        } finally {
            tm.release();
        }

    }
}
