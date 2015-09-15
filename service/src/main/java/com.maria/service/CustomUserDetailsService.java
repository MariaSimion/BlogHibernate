package com.maria.service;

import com.maria.facade.UserFacade;
import com.maria.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created by msimion on 9/14/2015.
 */
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserFacade userFacade;

    @Autowired
    private Assembler assembler;

    static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userFacade.getUser(s);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User details not found with this username %s", s));
        }

        return assembler.buildUserFromUserEntity(user);
    }

    public UserFacade getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(UserFacade userFacade) {
        this.userFacade = userFacade;
    }
}
