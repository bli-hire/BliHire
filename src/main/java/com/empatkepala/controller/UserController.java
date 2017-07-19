package com.empatkepala.controller;

import com.empatkepala.SessionInfo;
import com.empatkepala.entity.User;
import com.empatkepala.entity.request.AddUserRequest;
import com.empatkepala.entity.request.LoginRequest;
import com.empatkepala.repository.UserRepository;
import com.empatkepala.service.RoleService;
import com.empatkepala.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;

/**
 * Created by ARDI on 3/5/2017.
 */

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
            @RequestBody AddUserRequest addUserRequest){
        User user = new User();
        user.setName(addUserRequest.getName());
        user.setSurname(addUserRequest.getSurname());
        user.setRole(roleService.getRole(1L));
        user.setPassword(addUserRequest.getPassword());
        user.setEmail(addUserRequest.getEmail());
        userService.addUser(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User login(
            @RequestBody LoginRequest loginRequest, HttpSession httpSession){

                if(userService.getUser(loginRequest.getEmail(), loginRequest.getPassword()) != null){
                    User user = userService.getUser(loginRequest.getEmail(), loginRequest.getPassword());
                    SessionInfo sessionInfo = new SessionInfo(user);
                    httpSession.setAttribute("sessionInfo", sessionInfo);
                    httpSession.setAttribute("id", user.getId());
//                    return userService.getUser(loginRequest.getEmail(), loginRequest.getPassword());
                    return user;

                }

                return null;
    }
}
