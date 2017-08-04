package com.empatkepala.service.impl;

import com.empatkepala.entity.JobVacancy;
import com.empatkepala.enumeration.Department;
import com.empatkepala.repository.JobVacancyRepository;
import com.empatkepala.service.JobVacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Juan on 8/4/17.
 */

@Service
public class JobVacancyServiceImpl implements JobVacancyService{
    @Autowired
    JobVacancyRepository jobVacancyRepository;

    @Override
    public JobVacancy getByDepartment(Department department) {
        return jobVacancyRepository.findOneByDepartment(department);
    }

    @Override
    public void addPersonNeeded(Department department, int personNeeded) {
        JobVacancy toUpdateJobVacancy = jobVacancyRepository.findOneByDepartment(department);
        int finalAmmount = toUpdateJobVacancy.getAmmount() + personNeeded;
        toUpdateJobVacancy.setAmmount(finalAmmount);
        jobVacancyRepository.save(toUpdateJobVacancy);
//        return jobVacancyRepository.findOneByDepartment(department);
    }
}
