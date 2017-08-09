package com.empatkepala.service;

import com.empatkepala.entity.JobVacancy;
import com.empatkepala.enumeration.Department;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Juan on 8/4/17.
 */
@Service
public interface JobVacancyService {
    Collection<JobVacancy> getByDepartment(Department department);

    Collection<JobVacancy> getAll();

    void addPersonNeeded(Department department, int personNeeded, String position);

    void decreaseAmmount(String position);
}
