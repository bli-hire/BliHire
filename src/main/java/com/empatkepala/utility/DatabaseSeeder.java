package com.empatkepala.utility;

import com.empatkepala.entity.User;
import com.empatkepala.enumeration.Role;
import com.empatkepala.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class DatabaseSeeder {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void initDataTest(){

        User user = new User();
        user.setName("Dummy");
        user.setSurname("Account");
        user.setRole(Role.CEO);
        user.setPassword("dummy");
        user.setEmail("dummy@account.com");
        userRepository.save(user);

    }

}
