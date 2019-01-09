package com.itheima.dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserDao {
    /**
     * 查询所有
     * @return
     */
    @Select(value = "select * from sys_user")
    @Results({
            @Result(id = true,column = "id",property = "u_id"),
            @Result(column = "username",property = "username"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "birthday",property = "birthday"),
            @Result(column = "address",property = "address"),
            @Result(property = "accountList",column = "u_id",javaType = List.class,
            many = @Many(select = "com.itheima.dao.AccountDao.findAll",fetchType = FetchType.LAZY)
            )
    })
    public List<User> findAll();

}
