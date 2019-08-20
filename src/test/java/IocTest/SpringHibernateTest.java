package IocTest;

import com.piao.hibernate.repository.BookShopDao;
import com.piao.hibernate.service.BookShopService;
import com.piao.hibernate.service.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Arrays;

public class SpringHibernateTest {

    private ApplicationContext context = new ClassPathXmlApplicationContext("beans-hibernate.xml");
    @Test
    public void test01() throws SQLException {
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        System.out.println(dataSource.getConnection());

        // 为什么 hbm.ml的映射文件不能在，编译的target里生成，得手工网里加呢？？？
        String[] names = context.getBeanDefinitionNames();

        for(String name:names){
            System.out.println(name);
        }

        BookShopService bookShopService = (BookShopService) context.getBean("bookShopServiceImpl");
        bookShopService.purchaseBook("1001",1);
    }

    @Test
    public  void  test02(){

        Cashier cashierImpl = (Cashier) context.getBean("cashierImpl");
        cashierImpl.checkout(Arrays.asList("1001","1002"),1);
    }
}
