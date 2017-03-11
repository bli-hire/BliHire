package com.empatkepala.service.impl;

import com.empatkepala.entity.User;
import com.empatkepala.repository.UserRepository;
import com.empatkepala.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Juan on 3/11/17.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    public Collection<User> getAllUser(){
        return userRepository.findAll();
    }

    public User getUser(Long id){
        return userRepository.findOne(id);
    }

    public void addUser(User user){
        userRepository.save(user);
    }

}
