package IocTest;

import com.piao.spel.Address;
import com.piao.spel.Person;
import com.piao.spel.SuperCar;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpelTest {
    @Test
public void test01(){
    ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-spel.xml");
    Address address = (Address)ctx.getBean("address");
    SuperCar car = (SuperCar)ctx.getBean("car");
    Person person = (Person)ctx.getBean("person");
    System.out.println(address);
    System.out.println(car);
    System.out.println(person);
}
}
