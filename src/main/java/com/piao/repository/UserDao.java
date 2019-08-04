package com.piao.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addUser(String name, Integer age) {
        String sql = "insert into user (name,age) values(?,?)";
        jdbcTemplate.update(sql, name, age);
    }
}
