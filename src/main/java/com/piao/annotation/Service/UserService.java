package com.piao.annotation.Service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public void save(){
        System.out.println("user service save");
    };
}
