package com.empatkepala.controller;

import com.empatkepala.entity.User;
import com.empatkepala.entity.request.AddUserRequest;
import com.empatkepala.entity.request.LoginRequest;
import com.empatkepala.repository.UserRepository;
import com.empatkepala.service.RoleService;
import com.empatkepala.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController

@RequestMapping(value = "/users")
@CrossOrigin(origins = "*")
public class UserController {

    private UserService userService;

    @Autowired
    RoleService roleService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Collection<User> findAllUsers(){
        return userService.getAllUser();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addUser(
            @RequestBody AddUserRequest addUserRequest)
    {
        userService.addUser(addUserRequest);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User login(
            @RequestBody LoginRequest loginRequest)
    {
        return userService.getUser(loginRequest.getEmail(), loginRequest.getPassword());
    }
}
