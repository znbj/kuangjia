package com.itheima;

import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class testMybatis_spring {

    @Autowired
    AccountService accountService;

    @Test
    public void testFindAll() {

        List<Account> accountList = accountService.findAll();
        for (Account account : accountList) {
            System.out.println(account);
        }

    }
}
