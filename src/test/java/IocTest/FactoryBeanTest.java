package IocTest;

import com.piao.factorybean.Car;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryBeanTest {

    @Test
    public void test01(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-factorybean.xml");
        Car car = (Car)ctx.getBean("car");
        System.out.println(car);
        ctx.close();
    }
}
