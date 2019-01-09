package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    @Select("select * from sys_user where id =#{id}")
    public User findById(Integer id);


}
