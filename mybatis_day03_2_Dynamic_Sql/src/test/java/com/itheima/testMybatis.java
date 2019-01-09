package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
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
            System.out.println(user.toString());
        }

        sqlSession.close();
    }

    @Test
    public void testSave() {
        SqlSession sqlSession = sessionFactory.openSession(true);
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setUsername("王噢力");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("河南开封");
        userDao.save(user);
        sqlSession.close();
    }

    @Test
    public void testFindByCondition() {

        SqlSession sqlSession = sessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user1 = new User();
        user1.setUsername("力");
        user1.setSex("女");

        List<User> userList = userDao.findByCondition(user1);


        for (User user : userList) {
            System.out.println(user.toString());
        }

        sqlSession.close();

    }

    @Test
    public void testDel() {
        SqlSession sqlSession = sessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        Integer[] ids = new Integer[]{5, 6, 7};

        userDao.del(ids);

        sqlSession.close();
    }

    @Test
    public void testDelByList() {
        SqlSession sqlSession = sessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<Integer> ids = new ArrayList<>();
        ids.add(5);
        ids.add(6);
        ids.add(7);
        userDao.delByList(ids);

        sqlSession.commit();

        sqlSession.close();
    }
}
