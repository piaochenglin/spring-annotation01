package IocTest;

import com.piao.hello_world.SuperCar;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestScope {
    @Test
    public void test01(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-scope.xml");
        SuperCar car31 = (SuperCar)ctx.getBean("car31");
        SuperCar car32 = (SuperCar)ctx.getBean("car31");
        System.out.println(car31 == car32);
        System.out.println(car31.hashCode());
        System.out.println(car32.hashCode());
        System.out.println(car31);
        System.out.println(car32);
    }
}
