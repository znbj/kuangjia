package com.itheima.dao;

import com.itheima.domain.QueryVo;
import com.itheima.domain.User;

import java.util.List;
import java.util.Map;


public interface UserDao {

    public List<User> findAll();

    public User findById(Integer id);

    public void saveUser(User user);

    public void updateUser(User user);

    public void deleteUser(Integer id);

    public List<User> selectLike(String name);

    public Integer selectCount();

    //分页查询加模糊查询
    public List<User> findByQueryVo(QueryVo Q);

    //多条件查询

    public List<User> findUsers(Integer startIndex, Integer pageSize, String name);

    //map

    public List<User> findByMap(Map<String,Object> map);


}