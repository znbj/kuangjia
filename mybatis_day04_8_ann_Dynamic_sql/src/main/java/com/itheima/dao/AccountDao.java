package com.itheima.dao;

import com.itheima.domain.Account;
import com.itheima.provider.AccountProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有
     * @return
     */
    @Select(value = "select * from account where u_id=#{id}")
    public List<Account> findAll(Integer u_id);

    /**
     * @param account
     * @return
     */
    //@Select(value = "select * from account where cardNumber like \"%\"#{cardNumber}\"%\" and money > #{money}")
    @SelectProvider(type = AccountProvider.class, method = "findByCondition")
    public List<Account> findByCondition(Account account);

}
