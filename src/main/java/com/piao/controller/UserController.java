package com.piao.controller;

import com.piao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    public void addUser(String name,Integer age){
        userService.addUser(name,age);
    }

}
