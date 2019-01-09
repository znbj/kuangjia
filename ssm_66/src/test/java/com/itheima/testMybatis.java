package com.itheima;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/*")
public class testMybatis {
    @Autowired
    UserDao userDao;

    @Test
    public void testOjdbc() {

        User user = userDao.findById(1);
        System.out.println(user.getUsername());

    }

}
