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
        Role role = new Role();
        role.setRoleName("CEO");
        roleService.addRole(role); //role 1

        return;
    }
}
