package com.empatkepala.repository.OnlineTestRepository;

import com.empatkepala.entity.OnlineTestEntity.ProblemGenerator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemGeneratorRepository extends JpaRepository<ProblemGenerator, Long>{
}
