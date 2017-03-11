package com.empatkepala.repository;

import com.empatkepala.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Juan on 3/11/17.
 */
@Repository
public interface RoleRepository extends JpaRepository<Role,Long>{

}
