package IocTest;

import com.piao.factory.Car;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryTest {

    @Test
    public void test01(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-factory.xml");
        Car car = (Car)ctx.getBean("car1");
        Car car2 = (Car)ctx.getBean("car2");
        System.out.println(car);
        System.out.println(car2);
        ctx.close();
    }
}
