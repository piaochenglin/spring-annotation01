package com.piao.annotation.Service;

import com.piao.annotation.Repository.UserDao;
import com.piao.annotation.Repository.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

//    @Autowired
//    @Qualifier("userDaoImpl")
    private UserDao userDao;
    @Autowired
    public void setUserDao(@Qualifier("userDaoImpl")UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(){
        System.out.println("user service save");
        userDao.save();
    }
}
