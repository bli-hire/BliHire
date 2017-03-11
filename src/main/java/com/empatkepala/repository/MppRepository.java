package com.empatkepala.repository;

import com.empatkepala.entity.Mpp;
import com.empatkepala.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Juan on 3/11/17.
 */
@Repository
public interface MppRepository extends JpaRepository<Mpp, Long>{
    Mpp findByRequestedBy(User user);
}
