package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有
     * @return
     */
    @Select("select * from account")

    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "money", property = "money"),
            @Result(column = "cardNumber", property = "cardNumber"),
            @Result(column = "u_id", property = "u_id"),
            @Result(property = "user",column = "u_id",javaType = User.class,
            one = @One(select = "com.itheima.dao.UserDao.findById",fetchType = FetchType.LAZY)
            )

    })
    public List<Account> findAll();
}
