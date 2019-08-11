package com.piao.annotation.Repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("user dao save");
    }
}
