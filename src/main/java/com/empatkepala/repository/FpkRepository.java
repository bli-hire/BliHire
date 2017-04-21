package com.empatkepala.repository;

import com.empatkepala.entity.Fpk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ALz on 3/11/2017.
 */
@Repository
public interface FpkRepository extends JpaRepository<Fpk, Long> {
}
