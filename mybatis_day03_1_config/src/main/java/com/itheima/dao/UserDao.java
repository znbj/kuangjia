package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有
     * @return
     */
    public List<User> findAll();

    /**
     * 增加用户
     * @param user
     */
    public void save(User user);

}
