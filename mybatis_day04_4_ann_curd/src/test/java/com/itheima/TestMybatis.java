package com.itheima;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    SqlSessionFactory sessionFactory;
    @Before
    public void init() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("sqlMapConfig.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindAll() {
        SqlSession session = sessionFactory.openSession();
        AccountDao accountDao = session.getMapper(AccountDao.class);
        List<Account> accountList = accountDao.findAll();

        for (Account account : accountList) {
            System.out.println(account.getCardNumber());

        }

        session.close();
    }

    @Test
    public void testFindById() {
        SqlSession session = sessionFactory.openSession();
        AccountDao accountDao = session.getMapper(AccountDao.class);
        Account account = accountDao.findById(2);
        System.out.println(account.getCardNumber());


        session.close();
    }

    @Test
    public void testFindByNames() {
        SqlSession session = sessionFactory.openSession();
        AccountDao accountDao = session.getMapper(AccountDao.class);
        List<Account> accountList = accountDao.findByNames("7");

        for (Account account : accountList) {
            System.out.println(account.getCardNumber());

        }


        session.close();
    }

    @Test
    public void testSave() {
        SqlSession session = sessionFactory.openSession();
        AccountDao accountDao = session.getMapper(AccountDao.class);
        Account account = new Account();
        account.setCardNumber("66666");
        account.setMoney(20000.);
        account.setU_id(11);
        accountDao.save(account);
        session.commit();
        System.out.println(account.getId());
        session.close();
    }

    @Test
    public void testUpdate() {
        SqlSession session = sessionFactory.openSession();
        AccountDao accountDao = session.getMapper(AccountDao.class);
        Account account = new Account();
        account.setCardNumber("888888");
        account.setId(10);
        accountDao.update(account);
        session.commit();
        session.close();
    }


    @Test
    public void testDel() {
        SqlSession session = sessionFactory.openSession();
        AccountDao accountDao = session.getMapper(AccountDao.class);
        accountDao.del(10);
        session.commit();
        session.close();
    }

}
