package com.empatkepala.service;

import com.empatkepala.entity.User;
import com.empatkepala.entity.request.AddUserRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

/**
 * Created by Juan on 3/11/17.
 */

public interface UserService {
    public Collection<User> getAllUser();

    public User getUser(Long id);

    public void addUser(
            @RequestBody AddUserRequest addUserRequest);

    public User getUser(String email, String password);
}
