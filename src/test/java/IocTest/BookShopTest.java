package IocTest;

import com.piao.springTransaction.BookShopService;
import com.piao.springTransaction.Cashier;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class BookShopTest {
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans-book-shop.xml");
    private JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");

    @Test
    public void test01(){
        BookShopService bookShopService = (BookShopService) context.getBean("bookShopService");
        bookShopService.purchaseBook("1001",1);
    }

    @Test
    public void test02(){
        Cashier bookShopService = (Cashier) context.getBean("cashierImpl");
        List<String> isbns = new ArrayList<>();
        isbns.add("1001");
        isbns.add("1002");
        bookShopService.checkout(isbns,1);
        System.out.println("购买成功");
    }
}
