package com.empatkepala.repository;

import com.empatkepala.entity.JobVacancy;
import com.empatkepala.enumeration.Department;
import com.empatkepala.enumeration.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Juan on 8/4/17.
 */
@Repository
public interface JobVacancyRepository extends JpaRepository<JobVacancy, Long> {
//    JobVacancy findOneByDepartment(Department department);
    Collection<JobVacancy> findByDepartment(Department department);
    JobVacancy findOneByPosition(String position);

}
