package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface UserDao {

    /**
     *
     * @param id
     * @return
     */
    public User findById(Integer id);

    /**
     * 多条件查询
     * @param user
     * @return
     */
    public List<User> findByCondition(User user);


}
