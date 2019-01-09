package com.itheima;

import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test {

    AccountService accountService;
    @Before
    public void init() {
        ApplicationContext ac =new ClassPathXmlApplicationContext("applicationContext.xml");
        accountService = ac.getBean("AccountService", AccountService.class);
    }

    @Test
    public void testSelectAll() {
        List<Account> accountList = accountService.selectAll();
        for (Account account : accountList) {
            System.out.println(account.getName());
        }

    }
    @Test
    public void testFindById() {
        Account account = accountService.findById(2);
        System.out.println(account.getName());
    }
}
