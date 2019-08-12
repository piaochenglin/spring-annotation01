package com.piao.annotation.Repository;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserJdbcRepository implements UserDao {
    @Override
    public void save() {
        System.out.println("UserJdbcRepository");
    }
}
