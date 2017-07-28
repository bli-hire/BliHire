package com.empatkepala.service.impl;

import com.empatkepala.entity.User;
import com.empatkepala.entity.request.AddUserRequest;
import com.empatkepala.enumeration.Role;
import com.empatkepala.repository.UserRepository;
import com.empatkepala.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by Juan on 3/11/17.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User getUser(Long id){
        return userRepository.findOne(id);
    }

    public void addUser(
            @RequestBody AddUserRequest addUserRequest)
    {
        User user = new User();
        user.setName(addUserRequest.getName());
        user.setSurname(addUserRequest.getSurname());
        user.setRole(Role.CEO);
        user.setPassword(addUserRequest.getPassword());
        user.setEmail(addUserRequest.getEmail());
        userRepository.save(user);
    }

    @Override
    public User getUser(String email, String password) {

        return userRepository.findOneByEmailAndPassword(email, password);
    }

}
