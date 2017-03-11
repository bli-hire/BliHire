package com.empatkepala.controller;

import com.empatkepala.entity.User;
import com.empatkepala.entity.request.AddUserRequest;
import com.empatkepala.repository.UserRepository;
import com.empatkepala.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

/**
 * Created by ARDI on 3/5/2017.
 */

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Collection<User> findAllUsers(){
        return userService.getAllUser();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addUser(
            @RequestBody AddUserRequest addUserRequest){
        User user = new User();
        user.setName(addUserRequest.getName());
        user.setSurname(addUserRequest.getSurname());
        userService.addUser(user);
    }
}
