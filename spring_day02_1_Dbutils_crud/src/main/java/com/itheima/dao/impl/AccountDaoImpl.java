package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements AccountDao {
    QueryRunner qr;

    public void setQr(QueryRunner qr) {
        this.qr = qr;
    }

    @Override
    public List<Account> selectAll() {
        String sql = "select * from account";
        List<Account> list=null;
        try {
            list= qr.query(sql, new BeanListHandler<>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Account findById(Integer id) {

        String sql ="select * from account where id=?";
        Account account=null;
        try {
            account=qr.query(sql, new BeanHandler<>(Account.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return account;
    }
}
