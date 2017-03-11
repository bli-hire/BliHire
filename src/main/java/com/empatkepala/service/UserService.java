package com.empatkepala.service;

import com.empatkepala.entity.User;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Juan on 3/11/17.
 */

public interface UserService {
    public Collection<User> getAllUser();
    public User getUser(Long id);
    public void addUser(User user);
}
