package IocTest;

import com.piao.generic.User;
import com.piao.generic.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GenericTest {
    @Test
    public void test01(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-generic.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.save();
    }
}
