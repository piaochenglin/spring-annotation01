package com.piao.service;

import com.piao.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Transactional
    public void addUser(String name,Integer age){
        userDao.addUser(name,age);
        System.out.println("插入数据成功");
        int a =7/0;
    }
}
