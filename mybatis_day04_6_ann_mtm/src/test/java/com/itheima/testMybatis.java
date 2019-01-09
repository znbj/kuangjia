package com.itheima;

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
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("mybatis.xml");

        sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }


    @Test
    public void testFindAll() {

        SqlSession sqlSession = sessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.print("用户名:"+user.getUsername());
            List<Account> accountList = user.getAccountList();
            if (accountList != null) {
                for (Account account : accountList) {
                    System.out.print(",卡号:"+account.getCardNumber()+",余额:"+account.getMoney()+"::");
                }

            }

            System.out.println();
        }

        sqlSession.close();
    }


}
