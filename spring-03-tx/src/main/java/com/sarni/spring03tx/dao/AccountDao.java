package com.sarni.spring03tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AccountDao {
    @Autowired
    JdbcTemplate jdbcTemplate;
    // 输入用户名和金额，根据money扣除该账户的对应的余额
    public void updateAccountBalance(String username, BigDecimal money) {
        String sql = "update account set balance = balance - ? where username = ?";
        jdbcTemplate.update(sql, money, username);
    }

}
