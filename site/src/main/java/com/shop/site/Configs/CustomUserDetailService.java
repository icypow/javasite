package com.shop.site.Configs;

import com.shop.site.Service.*;
import com.shop.site.Entity.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

public class CustomUserDetailService implements UserDetailsService {
    ClientSVC cs = new ClientSVC();



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client cl = cs.findClientByLogin(username);
        User u = new User(username, cl.getPassword(), Collections.emptyList());
        System.out.println(u);
        return u;
    }
}
