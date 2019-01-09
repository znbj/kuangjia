package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import com.itheima.domain.User;

public class UserDaoImpl implements UserDao {

    public void save(User user) {
        System.out.println("保存成功");
    }
}
