package com.maria.daoImpl;

import com.maria.dao.UserDao;
import com.maria.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by msimion on 9/8/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:META-INF/dao/user-dao.xml", "classpath*:META-INF/spring/spring-jpa.xml"})
public class UserDaoImplIT extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    UserDao userDao;

    @Test
    public void testPersistUser() {

        List<User> before = userDao.getAll();
        User user = new User("test", "test");

        userDao.persist(user);

        List<User> after = userDao.getAll();
        Assert.assertTrue(before.size() < after.size());
    }

    @Test
    public void testGetUser() {

        User user = userDao.get(1);

        Assert.assertNotNull(user);
    }

    @Test
    public void testDeleteUser() {

        userDao.delete(4);
        User deletedUser = userDao.get(4);

        Assert.assertNull(deletedUser);
    }
}
