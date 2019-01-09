package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

public interface AccountService {
    /**
     * 查全部
     * @return
     */
    public List<Account> findAll();

    /**
     *新增
     * @param account
     */
    public void save(Account account);

    /**
     *修改
     * @param account
     */
    public void update(Account account);

    /**
     *根据id删除
     * @param id
     */
    public void delById(Integer id);

    /**
     *根据id查找
     * @param id
     * @return
     */
    public Account findById(Integer id);
}
