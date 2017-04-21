package com.empatkepala.service.impl;

import com.empatkepala.entity.Role;
import com.empatkepala.repository.RoleRepository;
import com.empatkepala.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ALz on 3/11/2017.
 */

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    RoleRepository roleRepository;

    @Override
    public void addRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role getRole(Long id) {
        return roleRepository.findOne(id);
    }
}
