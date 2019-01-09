package com.itheima.service.impl;

import com.itheima.service.AccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public void save() {
        System.out.println("保存成功");
        System.out.println(1/0);
    }
}
