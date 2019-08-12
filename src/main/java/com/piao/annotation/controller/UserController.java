package com.piao.annotation.controller;

import com.piao.annotation.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public void save(){
        System.out.println("user controller save");
        userService.save();
    }
}
