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

        session.close();

    }
}
