package com.piao.config;

import com.piao.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 配置类=配置文件
@Configuration //告诉spring 这是一个配置类
public class Mainconfig {

    // 给容器注册一个Bean,类型是返回值的类型,默认是用方法名作为id
    // 可以通过设置value，来改变id 的名字
    @Bean(value = "p1")
    public Person person1(){
        return new Person("james",28);
    }
}
