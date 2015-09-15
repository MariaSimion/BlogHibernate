package com.maria.service;

import org.springframework.security.core.userdetails.User;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by msimion on 9/14/2015.
 */
public class Assembler {

    User buildUserFromUserEntity(com.maria.model.User userEntity){

        String username = userEntity.getUsername();
        String password = userEntity.getPassword();

        Collection authorities = userEntity.getRoles();

        User user = new User(username, password, authorities);
        return user;
    }
}
