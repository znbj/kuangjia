package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

public interface AccountService {

    public List<Account> selectAll();

    public Account findById(Integer id);
}
