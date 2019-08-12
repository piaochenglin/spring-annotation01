package IocTest;

import com.piao.annotation.Repository.UserDao;
import com.piao.annotation.Service.UserService;
import com.piao.annotation.TestObject;
import com.piao.annotation.controller.UserController;
import com.piao.cycle.Car;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {

    @Test
    public void test01(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");
//        UserDao userDao = (UserDao)ctx.getBean("userDaoImpl");
//        UserService userService = (UserService)ctx.getBean("userService");
//        UserController userController = (UserController)ctx.getBean("userController");
//        TestObject testObject = (TestObject)ctx.getBean("testObject");
//
//        System.out.println(userDao);
//        System.out.println(userService);
//        System.out.println(userController);
//        System.out.println(testObject);

        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String name : beanDefinitionNames){
            System.out.println(name);
        }
        UserController userController = (UserController)ctx.getBean("userController");
        userController.save();
        ctx.close();
    }

}
