package com.empatkepala.repository.OnlineTestRepository;

import com.empatkepala.entity.OnlineTestEntity.TechnicalTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalTestRepository extends JpaRepository<TechnicalTest, Long>{



}
