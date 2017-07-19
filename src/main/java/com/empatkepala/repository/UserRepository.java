package com.empatkepala.repository;

import com.empatkepala.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ARDI on 3/5/2017.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    public User findOneByEmailAndPassword(String email, String password);

}
