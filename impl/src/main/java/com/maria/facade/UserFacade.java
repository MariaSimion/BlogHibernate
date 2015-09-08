package com.maria.facade;

import com.maria.api.IUserFacade;
import com.maria.daoImpl.UserDaoImpl;
import com.maria.model.User;

/**
 * Created by msimion on 8/31/2015.
 */
public class UserFacade implements IUserFacade{

    UserDaoImpl userDao;

    public void persist(User user) {
        userDao.persist(user);
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

    public void deleteUser(User user){
        userDao.delete(user.getId());
    }
}
