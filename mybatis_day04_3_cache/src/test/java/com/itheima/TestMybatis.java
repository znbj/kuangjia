package com.itheima;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestMybatis {
    SqlSessionFactory sessionFactory;
    @Before
    public void init() {
        sessionFactory = new SqlSessionFactoryBuilder().build(this.getClass().getClassLoader().getResourceAsStream("sqlMapConfig.xml"));
    }

    @Test
    public void testFindAll() {
        SqlSession session = sessionFactory.openSession();
        AccountDao accountDao = session.getMapper(AccountDao.class);

        List<Account> accountList = accountDao.findAll();

        for (Account account : accountList) {
            System.out.println(account.getCardNumber());
            System.out.println(account.getUser().getUsername());
        }
        System.out.println("_------------------------------------------------------------");
        AccountDao accountDao2 = session.getMapper(AccountDao.class);

        List<Account> accountList2 = accountDao2.findAll();

        for (Account account : accountList2) {
            System.out.println(account.getCardNumber());
            System.out.println(account.getUser().getUsername());
        }

        session.close();

        System.out.println("_____________------------------------------------___________________________________________________________");
        SqlSession session1 = sessionFactory.openSession();
        AccountDao accountDao1 = session1.getMapper(AccountDao.class);

        List<Account> accountList1 = accountDao1.findAll();

        for (Account account : accountList1) {
            System.out.println(account.getCardNumber());
            System.out.println(account.getUser().getUsername());
        }

        session1.close();


    }
}
