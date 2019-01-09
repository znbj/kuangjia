package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

public interface AccountService {
    /**
     *
     * @return
     */
    public List<Account> selectAll();

    /**
     *
     * @param fromName
     * @param toName
     * @param money
     */
    public void transfer(String fromName, String toName, Float money);
}
