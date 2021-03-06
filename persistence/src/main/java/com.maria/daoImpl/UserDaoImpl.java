package com.maria.daoImpl;

import com.maria.dao.GenericDao;
import com.maria.dao.UserDao;
import com.maria.model.Article;
import com.maria.model.User;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by msimion on 8/31/2015.
 */
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

    public UserDaoImpl() {
        super(User.class);
    }

    public User persist(User user) {
        if (user.getId() != 0) {
            entityManager.merge(user);
        } else {
            persist(user);
        }
        return user;
    }

    public User getUser(String username) {

        Query query = entityManager.createQuery("from User where username=:username");
        query.setParameter("username", username);
        return (User) query.getSingleResult();
    }
}
