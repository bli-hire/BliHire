package com.empatkepala.repository;

import com.empatkepala.entity.JobVacancy;
import com.empatkepala.enumeration.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Juan on 8/4/17.
 */
@Repository
public interface JobVacancyRepository extends JpaRepository<JobVacancy, Long> {
    JobVacancy findOneByDepartment(Department department);

}
