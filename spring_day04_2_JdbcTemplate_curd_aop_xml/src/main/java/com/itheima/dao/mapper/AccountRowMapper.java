package com.itheima.dao.mapper;

import com.itheima.domain.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setMoney(rs.getFloat("money"));
        account.setId(rs.getInt("id"));
        account.setName(rs.getString("name"));
        return account;
    }
}
