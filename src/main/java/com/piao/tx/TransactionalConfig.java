package com.piao.tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/*
  声明式事务
  环境搭建：
    1，导入相关依赖
       pom文件c3p0依赖配置，mysql依赖配置，spring-jdbc依赖
    2，配置数据源，JdbcTemplate(Spring 提供的简化数据库的操作)操作数据
    3，给方法标上@Transactional，表示当前方法时一个事务方法
    4，@EnableTransactionManagement,开启基于注解的事务管理功能；
    5，PlatformTransactionManager,配置事务管理器来管理事务；
 */
@EnableTransactionManagement
@ComponentScan("com.piao")
@Configuration
public class TransactionalConfig {

    @Bean
    public DataSource dataSource() throws Exception {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("123456");
        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://192.168.1.102:3306/spring?useSSL=false");
        return comboPooledDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws Exception {
        // spring 对@Configuration的类会特殊处理；给容器中加组件的方法，多次调用只是从容器中找组件
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager() throws Exception {

        return new DataSourceTransactionManager(dataSource());
    }

}
