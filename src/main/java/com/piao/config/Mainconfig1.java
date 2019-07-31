package com.piao.config;

import com.piao.Person;
import com.piao.condition.LinuxCondition;
import com.piao.condition.WindowsCondition;
import com.piao.service.UserService;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

import java.awt.*;


@Configuration
public class Mainconfig1 {

    @Bean()
    public Person person1(){
        return new Person("james",28);
    }

    @Bean()
    @Conditional(value = {WindowsCondition.class})
    public Person windows(){
        return new Person("bill gates",65);
    }


    @Bean()
    @Conditional(value = {LinuxCondition.class})
    public Person linux(){
        return new Person("linus",45);
    }
}
