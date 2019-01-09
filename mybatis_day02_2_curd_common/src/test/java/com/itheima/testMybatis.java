package com.itheima;

import com.itheima.dao.UserDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class testMybatis {
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(this.getClass().getClassLoader().getResourceAsStream("SqlMapConfig.xml"));
    }

    @Test
    public void findAll() {



        UserDao userDao = new UserDao(sqlSessionFactory);
        userDao.findAll();
    }
}
