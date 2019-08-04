package IocTest;

import com.piao.controller.UserController;
import com.piao.tx.TransactionalConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TxTest {
    AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(TransactionalConfig.class);
    @Test
    public void test01(){
        UserController bean = annotationConfigApplicationContext.getBean(UserController.class);
        bean.addUser("james",19);
    }
}
