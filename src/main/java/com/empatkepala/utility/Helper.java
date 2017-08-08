package com.empatkepala.utility;

import com.empatkepala.entity.User;

import com.empatkepala.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.Principal;

/**
 * Created by ARDI on 8/7/2017.
 */
@Component
public class Helper {

    @Autowired
    UserRepository userRepository;
    @Autowired
    protected AuthenticationManager authenticationManager;

    public boolean isLoggedIn() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken) ;
    }

    public User getCurrentUser() {
        if (isLoggedIn()) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            System.out.println(authentication.getName());
            return userRepository.findByUsername(authentication.getName());
        }
        System.out.println("not logged in");
        return null;
    }

}
