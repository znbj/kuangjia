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

    /**
     * 多条件查询
     * @param user
     * @return
     */
    public List<User> findByCondition(User user);

    /**
     * 删除多个 array
     * @param
     */
    public void del(Integer[] ids);

    /**
     * list foreach
     * @param ids
     */
    public void delByList(List<Integer> ids);

}
