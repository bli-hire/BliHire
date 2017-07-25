package com.empatkepala;

import com.empatkepala.entity.Role;
import com.empatkepala.service.RoleService;
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

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
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

        return;
    }
}
