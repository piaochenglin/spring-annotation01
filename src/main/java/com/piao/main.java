package com.piao;

import com.piao.config.Mainconfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// spring的两种配置的方式
public class main {
    public static void main(String[] args) {
        // 配置的方式取得Bean
//        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("beans.xml");
//        Object person = classPathXmlApplicationContext.getBean("person");
//        System.out.println(person);

        // 注释的方式取得Bean
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Mainconfig.class);
//        Object person1 = annotationConfigApplicationContext.getBean("person");
        Object person2 = annotationConfigApplicationContext.getBean(Person.class);
//        System.out.print(person1.hashCode()+":");
//        System.out.println(person1);
        System.out.print(person2.hashCode() + ":");
        System.out.println(person2);

        // 输出bean的id，验证注释方式时，方法名就是默认id
        String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(Person.class);
        for (String name : beanNamesForType) {
            System.out.println(name);
        }
    }
}
