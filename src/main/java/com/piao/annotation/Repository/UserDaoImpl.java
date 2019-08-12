package com.piao.annotation.Repository;

import com.piao.annotation.TestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired(required = false)
//    @Autowired
    private TestObject testObject;
    @Override
    public void save() {
        System.out.println("user dao save");
        System.out.println(testObject);
    }
}
