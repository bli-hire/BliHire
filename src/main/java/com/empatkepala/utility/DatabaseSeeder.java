package com.empatkepala.utility;

import com.empatkepala.entity.Role;
import com.empatkepala.entity.User;
import com.empatkepala.repository.UserRepository;
import com.empatkepala.service.RoleService;
import com.empatkepala.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class DatabaseSeeder {

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void initDataTest(){

        Role role1 = new Role();
        role1.setRoleName("CEO");
        roleService.addRole(role1); //role 1

        Role role2 = new Role();
        role2.setRoleName("HR");
        roleService.addRole(role2); //role 2

        Role role3 = new Role();
        role3.setRoleName("Department Head");
        roleService.addRole(role3); //role 3

        Role role4 = new Role();
        role4.setRoleName("Department Team Member");
        roleService.addRole(role4); //role 4

        User user = new User();
        user.setName("Dummy");
        user.setSurname("Account");
        user.setRole(roleService.getRole(1L));
        user.setPassword("dummy");
        user.setEmail("dummy@account.com");
        userRepository.save(user);
        System.out.print(roleService.getRole(1L).getRoleName());

    }

}
