package com.maria.facade;

import com.maria.daoImpl.UserDaoImpl;
import com.maria.model.User;

/**
 * Created by msimion on 8/31/2015.
 */
public class UserFacade {

    UserDaoImpl userDao;

    public void saveUser(User user) {
        userDao.save(user);
    }

    public User getUser(int id) {
        return userDao.get(id);
    }

    public UserDaoImpl getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }
}
