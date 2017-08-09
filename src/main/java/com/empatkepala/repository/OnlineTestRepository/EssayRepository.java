package com.empatkepala.repository.OnlineTestRepository;

import com.empatkepala.entity.OnlineTestEntity.Essay;
import com.empatkepala.enumeration.Department;
import com.empatkepala.enumeration.ProblemDifficulty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ARDI on 8/6/2017.
 */
@Repository
public interface EssayRepository extends JpaRepository<Essay,Long>{

    List<Essay> findAllByDepartment(Department department);

    List<Essay> findAllByProblemDifficulty(ProblemDifficulty problemDifficulty);

}
