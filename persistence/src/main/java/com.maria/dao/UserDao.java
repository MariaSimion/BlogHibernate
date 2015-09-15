package com.maria.dao;

import com.maria.model.Article;
import com.maria.model.User;

import java.util.List;

/**
 * Created by msimion on 8/31/2015.
 */
public interface UserDao extends GenericDao<User> {

    User getUser(String username);
}
