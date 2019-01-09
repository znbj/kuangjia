package com.itheima.dao;

import com.itheima.domain.Account;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有
     * @return
     */
    @Select(value = "select * from account where u_id=#{id}")
    public List<Account> findAll(Integer u_id);



}
