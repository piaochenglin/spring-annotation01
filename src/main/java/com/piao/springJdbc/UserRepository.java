package com.piao.springJdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
     private JdbcTemplate jdbcTemplate;

    public User getUser(Integer id){

        String sql = "select id ,name,age,email,dept_id from user where id=?;";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        User user = (User) jdbcTemplate.queryForObject(sql,rowMapper,id);
        return user;
    }
}
