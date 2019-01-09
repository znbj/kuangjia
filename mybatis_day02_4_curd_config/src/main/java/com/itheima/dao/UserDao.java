package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface UserDao {

    public List<User> findAll();

    public User findById(Integer id);

    public void saveUser(User user);

    public void updateUser(User user);

    public void deleteUser(Integer id);

    public List<User> selectLike(String name);

    public Integer selectCount();


}
