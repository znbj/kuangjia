package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.dao.mapper.AccountRowMapper;
import com.itheima.domain.Account;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;


public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    @Override
    public List<Account> selectAll() {
        String sql="select * from account";
        return this.getJdbcTemplate().query(sql, new AccountRowMapper());
    }

    @Override
    public Account findById(Integer id) {
        String sql="select * from account where id=?";

        return this.getJdbcTemplate().queryForObject(sql, new AccountRowMapper(),id);
    }

    @Override
    public void save(Account account) {
        String sql="insert into account values(null,?,?)";
        this.getJdbcTemplate().update(sql, account.getName(), account.getMoney());
    }

    @Override
    public void update(Account account) {
        String sql="update account set name=?,money=? where id = ?";
        this.getJdbcTemplate().update(sql, account.getName(), account.getMoney(), account.getId());
    }

    @Override
    public void del(Integer id) {
        String sql = "delete from account where id=?";
        this.getJdbcTemplate().update(sql, id);
    }

    @Override
    public Account findByName(String name) {
        String sql = "select * from account where name=?";
        return this.getJdbcTemplate().queryForObject(sql, new AccountRowMapper(), name);
    }

    @Override
    public Integer findTotal() {
        String sql="select count(*) from account";
        return this.getJdbcTemplate().queryForObject(sql, Integer.class);
    }
}
