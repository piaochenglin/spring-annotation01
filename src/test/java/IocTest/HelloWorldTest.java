package IocTest;

import com.piao.hello_world.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldTest {

    @Test
    public void test01() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
//        HelloWorld helloWorld = (HelloWorld)ctx.getBean("helloWorld");
//        HelloWorld helloWorld = ctx.getBean(HelloWorld.class);
        SuperCar superCar1 = (SuperCar)ctx.getBean("superCar");
        SuperCar superCar2 = (SuperCar)ctx.getBean("superCar2");
        SuperCar car11 = (SuperCar)ctx.getBean("car11");
        Person xiaowang = (Person)ctx.getBean("xiaowang");
        Person xiaoli = (Person)ctx.getBean("xiaoli");
        Person2 xin = (Person2)ctx.getBean("xin");
        Person3 ren3 = (Person3)ctx.getBean("ren3");
        DataSource dataSource = (DataSource)ctx.getBean("dataSource");
        Person4 person4 = (Person4)ctx.getBean("person4");
        Person4 person5 = (Person4)ctx.getBean("person5");
        System.out.println(superCar1);
        System.out.println(superCar2);
        System.out.println(car11);
        System.out.println(xiaowang);
        System.out.println(xiaoli);
        System.out.println(xin);
        System.out.println(ren3);
        System.out.println(dataSource.getProperties());
        System.out.println(person4);
        System.out.println(person5);
//        helloWorld.say();

    }

}
