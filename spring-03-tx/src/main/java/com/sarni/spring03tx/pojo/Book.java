package com.sarni.spring03tx.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Book {
    Integer id;
    String bookName;
    BigDecimal price;
    Integer stock;
}
