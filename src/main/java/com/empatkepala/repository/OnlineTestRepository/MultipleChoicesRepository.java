package com.empatkepala.repository.OnlineTestRepository;

import com.empatkepala.entity.OnlineTestEntity.MultipleChoices;
import com.empatkepala.enumeration.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ARDI on 8/6/2017.
 */
@Repository
public interface MultipleChoicesRepository extends JpaRepository<MultipleChoices,Long>{

    List<MultipleChoices> findAllByDepartment(Department department);

}
