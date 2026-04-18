package com.sarni.spring03tx;

import com.sarni.spring03tx.dao.AccountDao;
import com.sarni.spring03tx.dao.BookDao;
import com.sarni.spring03tx.pojo.Book;
import com.sarni.spring03tx.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class Spring03TxApplicationTests {
    @Autowired
    DataSource dataSource;

    @Autowired
    BookDao bookDao;

    @Autowired
    AccountDao accountDao;

    @Autowired
    UserService userService;

    @Test
    void testCheckoutMethod() {
        userService.checkout("zhangsan", 1,3);
    }

    @Test
    void testAccountUpdate() {
        accountDao.updateAccountBalance("zhangsan", new BigDecimal(100));
    }

    @Test
    void testDeleteBookById() {
        bookDao.deleteBookById(4);
    }

    @Test
    void testUpdateBookStock() {
        bookDao.updateBookStock(1, 999);
    }


    @Test
    void testBookQuery() {
        Book book = bookDao.getBookById(1);
        System.out.println(book);
    }

    @Test
    void testBookAdd(){
        Book book = new Book();
        book.setBookName("剑指Python");
        book.setPrice(new BigDecimal(100));
        book.setStock(10);
        bookDao.addBook(book);
    }

    @Test
    void contextLoads() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

}
