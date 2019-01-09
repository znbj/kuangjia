package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.utils.ConnectionUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    QueryRunner qr;

    @Autowired
    ConnectionUtil conn;

    @Override
    public List<Account> selectAll() {
        return null;
    }

    @Override
    public Account findByName(String name) {
        String sql="select * from account where name=?";
        Account account =null;
        try {
            account=qr.query(conn.getThreadConnection(),sql, new BeanHandler<>(Account.class), name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;

    }

    @Override
    public void update(Account account) {

        String sql="update account set money=? where id=?";
        try {
            qr.update(conn.getThreadConnection(),sql, account.getMoney(), account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
