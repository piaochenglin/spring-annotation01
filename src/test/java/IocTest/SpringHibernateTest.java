package IocTest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

public class SpringHibernateTest {

    private ApplicationContext context = new ClassPathXmlApplicationContext("beans-hibernate.xml");
    @Test
    public void test01() throws SQLException {
        DataSource dataSource = (DataSource) context.getBean("dataSource");
        System.out.println(dataSource.getConnection());
    }
}
