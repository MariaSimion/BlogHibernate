package com.maria.api;

import com.maria.daoImpl.UserDaoImpl;
import com.maria.model.User;

/**
 * Created by msimion on 9/2/2015.
 */
public interface IUserFacade {
    void persist(User user);

    User getUser(int id);

    UserDaoImpl getUserDao();

    void setUserDao(UserDaoImpl userDao);

    void deleteUser(User user);
}
