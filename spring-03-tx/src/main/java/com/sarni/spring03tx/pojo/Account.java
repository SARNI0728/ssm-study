package com.sarni.spring03tx.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Account {
    Integer id;
    String username;
    Integer age;
    BigDecimal balance;
}
