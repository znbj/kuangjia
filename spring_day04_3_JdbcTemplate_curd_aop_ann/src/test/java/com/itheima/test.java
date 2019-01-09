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
public class test {
    @Autowired
    AccountService accountService;
    @Test
    public void testSelectAll() {
        List<Account> accountList = accountService.selectAll();
        for (Account account : accountList) {
            System.out.println(account.getName());
            System.out.println(account.getId());
            System.out.println(account.getMoney());
        }
    }

    @Test
    public void testFindByName() {
        Account account = accountService.findByName("aaa");

        System.out.println(account.getName());
        System.out.println(account.getId());
        System.out.println(account.getMoney());

    }

    @Test
    public void testFindById() {
        Account account = accountService.findById(1);

        System.out.println(account.getName());
        System.out.println(account.getId());
        System.out.println(account.getMoney());

    }
    @Test
    public void testUpdate() {
        Account account = new Account();
        account.setName("eee");
        account.setMoney(10000f);
        account.setId(1);
        accountService.update(account);

    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("fff");
        account.setMoney(1000220f);
        accountService.save(account);

    }
    @Test
    public void testDel() {

        accountService.del(5);

    }
    @Test
    public void testFindTotal() {
        Integer total = accountService.findTotal();
        System.out.println(total);
    }
    @Test
    public void testTransfer() {
        accountService.transfer("bbb", "ccc", 100f);
    }

}
