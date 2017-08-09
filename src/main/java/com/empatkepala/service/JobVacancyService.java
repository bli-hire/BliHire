package com.empatkepala.service;

import com.empatkepala.entity.JobVacancy;
import com.empatkepala.enumeration.Department;
import org.springframework.stereotype.Service;

/**
 * Created by Juan on 8/4/17.
 */
@Service
public interface JobVacancyService {
    JobVacancy getByDepartment(Department department);

    void addPersonNeeded(Department department, int personNeeded);
}
