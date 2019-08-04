package IocTest;

import com.piao.Person;
import com.piao.aop.MathCalculator;
import com.piao.config.MainConfigOfAop;
import com.piao.config.Mainconfig;
import com.piao.config.Mainconfig1;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocTest {

    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfigOfAop.class);

    @Test
    public void Test01() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Mainconfig.class);
        String[] beanDefinitionNames = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            System.out.println(name);
        }
    }

    @Test
    public void test02() {
        String[] beanNamesForType = annotationConfigApplicationContext.getBeanNamesForType(Person.class);
        printBeanNames(beanNamesForType);
    }

    @Test
    public void test03() {
//        MathCalculator bean = (MathCalculator)annotationConfigApplicationContext.getBean("calculator");
        MathCalculator bean = annotationConfigApplicationContext.getBean(MathCalculator.class);
        int retVal =bean.div(6,2);
        System.out.println(retVal);

    }

    private void printBeanNames(String[] beanNamesForType) {
        for (String name : beanNamesForType) {
            System.out.println(name);
        }

    }
}
