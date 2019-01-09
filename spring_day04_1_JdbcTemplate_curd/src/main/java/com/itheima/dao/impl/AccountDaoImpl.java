package com.itheima.dao.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.dao.mapper.AccountRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImpl implements AccountDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Account> selectAll() {
        String sql="select * from account";
        return jdbcTemplate.query(sql, new AccountRowMapper());
    }

    @Override
    public Account findById(Integer id) {
        String sql="select * from account where id=?";

        return jdbcTemplate.queryForObject(sql, new AccountRowMapper(),id);
    }

    @Override
    public void save(Account account) {
        String sql="insert into account values(null,?,?)";
        jdbcTemplate.update(sql, account.getName(), account.getMoney());
    }

    @Override
    public void update(Account account) {
        String sql="update account set name=?,money=? where id = ?";
        jdbcTemplate.update(sql, account.getName(), account.getMoney(), account.getId());
    }

    @Override
    public void del(Integer id) {
        String sql = "delete from account where id=?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Account findByName(String name) {
        String sql = "select * from account where name=?";
        return jdbcTemplate.queryForObject(sql, new AccountRowMapper(), name);
    }

    @Override
    public Integer findTotal() {
        String sql="select count(*) from account";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
