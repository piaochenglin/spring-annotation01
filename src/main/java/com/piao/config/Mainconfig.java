package com.piao.config;

import com.piao.Person;
import com.piao.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

// 配置类=配置文件
@Configuration //告诉spring 这是一个配置类
@ComponentScan(value = "com.piao" ,
        excludeFilters ={@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})},
        useDefaultFilters = false ,
        includeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = UserService.class)})
public class Mainconfig {

    // 给容器注册一个Bean,类型是返回值的类型,默认是用方法名作为id
    // 可以通过设置value，来改变id 的名字
    @Bean(value = "p1")
    public Person person1(){
        return new Person("james",28);
    }
}
