package IocTest;

import com.piao.annotationAopLog.ArithmeticCalculator;
import com.piao.annotationAopLog.ArithmeticCalculatorImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationAopTest {

    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-annotation-aop.xml");
        String[] names = context.getBeanDefinitionNames();
//        for (String name : names){
//            System.out.println(name);
//        }
        // 用class类型取bean时，应该用接口的class类型，因为代理类型准定不是以前的class类型了
        ArithmeticCalculator bean = (ArithmeticCalculator) context.getBean(ArithmeticCalculator.class);
        System.out.println(bean.getClass().getName());
        int result = bean.add(7,3);
        System.out.println(result);
        result = bean.sub(7,3);
        System.out.println(result);
        result = bean.div(4,2);
        System.out.println(result);
        bean.noResult();
    }
}
