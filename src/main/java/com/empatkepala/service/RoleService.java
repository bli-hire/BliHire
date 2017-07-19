package com.empatkepala.service;

import com.empatkepala.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ALz on 3/11/2017.
 */
@Service
public interface RoleService {
    public void addRole(Role role);
    public Role getRole(Long id);
}
