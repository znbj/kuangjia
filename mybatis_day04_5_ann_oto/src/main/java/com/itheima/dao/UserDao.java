package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
    @Select(value = "select * from sys_user where u_id=#{id}")
    public User findById(Integer id);

}
