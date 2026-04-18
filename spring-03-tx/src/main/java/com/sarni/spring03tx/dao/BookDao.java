package com.sarni.spring03tx.dao;

import com.sarni.spring03tx.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BookDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public Book getBookById(Integer id) {

        String sql = "select * from book where id = ?";

        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Book.class), id);
    }

    public boolean addBook(Book book) {
        String sql = "insert into book(bookName, price, stock) values(?, ?, ?)";

        return jdbcTemplate.update(sql, book.getBookName(), book.getPrice(), book.getStock()) > 0;
    }

    public boolean updateBookStock(Integer id, Integer stock) {
        String sql = "update book set stock = ? where id = ?";

        return jdbcTemplate.update(sql, stock, id) > 0;
    }

    public boolean deleteBookById(Integer id) {
        String sql = "delete from book where id = ?";

        return jdbcTemplate.update(sql, id) > 0;
    }
}
