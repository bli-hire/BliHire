package com.empatkepala.repository;

import com.empatkepala.entity.CV;
import com.empatkepala.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Ryan Bagus Susilo on 4/21/2017.
 */
@Repository
public interface CVRepository extends JpaRepository<CV, Long> {
    Collection<CV> findByUid(String uid);
    CV findOneByUid(String uid);
//    CV findFirstByOrderByUidDesc();
}
