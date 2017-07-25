package com.empatkepala;

import com.empatkepala.entity.Role;
import com.empatkepala.entity.User;
import com.empatkepala.service.RoleService;
import com.empatkepala.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by Juan on 4/21/17.
 */
@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Role role1 = new Role();
        role1.setRoleName("CEO");
        roleService.addRole(role1); //role 1

        Role role2 = new Role();
        role2.setRoleName("HR");
        roleService.addRole(role2); //role 2

        Role role3 = new Role();
        role3.setRoleName("Department");
        roleService.addRole(role3);

        User userCeo = new User();
        userCeo.setEmail("ceo@mail.com");
        userCeo.setName("ceo");
        userCeo.setPassword("1234");
        userCeo.setRole(roleService.getRole(1L));

        User userHrd = new User();
        userHrd.setEmail("hrd@mail.com");
        userHrd.setName("hrd");
        userHrd.setPassword("1234");
        userHrd.setRole(roleService.getRole(2L));

        User userDepartment = new User();
        userDepartment.setEmail("department@mail.com");
        userDepartment.setName("department");
        userDepartment.setPassword("1234");
        userDepartment.setRole(roleService.getRole(3L));

        userService.addUser(userCeo);
        userService.addUser(userHrd);
        userService.addUser(userDepartment);

        return;
    }
}
