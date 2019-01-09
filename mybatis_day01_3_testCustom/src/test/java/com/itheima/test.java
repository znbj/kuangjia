package com.itheima;

import com.itheima.domain.User;
import frame.dao.sqlSession;
import frame.factory.sqlSessionFactory;
import frame.factory.sqlSessionFactoryBuilder;

import java.util.List;

public class test {
    public static void main(String[] args) {
        sqlSessionFactoryBuilder sqlSessionFactoryBuilder = new sqlSessionFactoryBuilder();
        sqlSessionFactory builder = sqlSessionFactoryBuilder.builder();

        sqlSession sqlSession = builder.openSession();
        List<User> list = sqlSession.selectList("com.itheima.dao.UserDao.findAll");
        for (User user : list) {
            System.out.println(user.getUsername());

        }

    }
}
