package IocTest;

import com.piao.springJdbc.User;
import com.piao.springJdbc.UserRepository;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpringJdbcTest {
    private ApplicationContext context = new ClassPathXmlApplicationContext("beans-properties.xml");
    private JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");


    @Test
    public void test01() throws SQLException {

    }

    @Test
    public void testUpdate() {
        String sql = " update user set name = ? ,age=? where id =?;";
        jdbcTemplate.update(sql, "aaa", 20,2);
    }

    @Test
    public void batchUpdate(){
        String sql = "update user set name = ? ,age=? where id =?;";
        List<Object[]> args = new ArrayList<>();
        args.add(new Object[]{"bbb",30,2});
        args.add(new Object[]{"ccc",40,4});
        args.add(new Object[]{"ddd",50,5});
        args.add(new Object[]{"eee",60,7});
        jdbcTemplate.batchUpdate(sql,args);
    }

    // 插入数据时，updatetime和createtime都不会自动生成，更新时两个都一起生产时间，不知道为什么？
    @Test
    public void batchInsert(){
        String sql = "insert into user ( name ,email,age , dept_id) values (?,?,?,?);";
        List<Object[]> args = new ArrayList<>();
        args.add(new Object[]{"X","X@163.com",77,1});
        args.add(new Object[]{"Y","Y@163.com",88,2});
        args.add(new Object[]{"Z","Z@163.com",99,2});
        jdbcTemplate.batchUpdate(sql,args);
    }

    @Test
    public void testQueryForObject(){
        String sql = "select id ,name,age,email,dept_id from user where id=?;";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        User user = (User) jdbcTemplate.queryForObject(sql,rowMapper,5);
        System.out.println(user);
    }

    @Test
    public void testQueryForObjectList(){
        String sql = "select id ,name,age,email,dept_id from user where id>?;";
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        List<User> users = jdbcTemplate.query(sql,rowMapper,3);
        System.out.println(users);
    }

    @Test
    public void testQueryForObject2(){
        String sql = "select count(*) from user;";
        Long count = jdbcTemplate.queryForObject(sql,Long.class);
        System.out.println(count);
    }

    @Test
    public void testUserRepository(){
        UserRepository userRepository = (UserRepository) context.getBean("userRepository");
        User user = userRepository.getUser(10);

        System.out.println(user);
    }
}
