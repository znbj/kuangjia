package com.itheima;

import com.itheima.dao.AccountDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.Account;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class testMybatis {
    SqlSessionFactory sessionFactory;
    @Before
    public void init() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("sqlMapConfig.xml");
        sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }



    @Test
    public void testAccountFindAll() {

        SqlSession sqlSession = sessionFactory.openSession();
        AccountDao accountDao = sqlSession.getMapper(AccountDao.class);
        List<Account> accountList = accountDao.findAll();
        for (Account account : accountList) {
            System.out.print(account.toString());

            System.out.println();
        }

        sqlSession.close();
    }
    @Test
    public void testFindById() {

        SqlSession sqlSession = sessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        User user = userDao.findById(11);
        System.out.println(user.getUsername());
        sqlSession.close();
    }


}
