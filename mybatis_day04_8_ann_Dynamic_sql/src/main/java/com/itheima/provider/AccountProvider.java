package com.itheima.provider;

import com.itheima.domain.Account;

/**
 * account sql语句的提供者
 */
public class AccountProvider {


    public String findByCondition(Account account) {
        StringBuilder sb = new StringBuilder();
        sb.append("select * from account where 1=1 ");
        if (account.getCardNumber() != null && account.getCardNumber() != "") {
            sb.append(" and cardNumber like \"%\"#{cardNumber}\"%\" ");
        }
        if (account.getMoney() != null) {
            sb.append(" and money > #{money} ");
        }

        return sb.toString();
    }
}
