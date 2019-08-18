package com.piao.springTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class BookShopDaoImpl implements BookShopDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public BigDecimal getBookPrice(String isbn) {
        String sql = "select price from book where isbn = ?";
        return jdbcTemplate.queryForObject(sql, BigDecimal.class,isbn);
    }

    @Override
    public BigDecimal getBalance(int id) {
        String sql = "select balance from account where id = ?";
        return jdbcTemplate.queryForObject(sql, BigDecimal.class,id);
    }

    @Override
    public int getBookStock(String isbn) {
        String sql = "select stock from book_stock where isbn = ?";
        return jdbcTemplate.queryForObject(sql, Integer.class,isbn);
    }

    @Override
    public void updateAccountBalance(int userId, BigDecimal price) {
        String sql = "update account set balance = balance - ? where id = ?";
        jdbcTemplate.update(sql,price,userId);
    }

    @Override
    public void updateBookStock(String isbn) {
        String sql = "update book_stock set stock = stock -1 where isbn = ?";
        jdbcTemplate.update(sql,isbn);
    }
}
