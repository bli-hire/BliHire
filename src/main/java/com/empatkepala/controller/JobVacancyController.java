package com.empatkepala.controller;

import com.empatkepala.entity.JobVacancy;
import com.empatkepala.entity.response.JobVacancyResponse;
import com.empatkepala.enumeration.Department;
import com.empatkepala.service.JobVacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Ryan Bagus Susilo on 8/8/2017.
 */
@RestController
@RequestMapping(value="/getJobVacancy")
@CrossOrigin(origins = "*")
public class JobVacancyController {
    @Autowired
    JobVacancyService jobVacancyService;

    @RequestMapping(method= RequestMethod.GET)
    public JobVacancyResponse getAllCV(@RequestHeader Department department) {
        JobVacancyResponse result = new JobVacancyResponse();
        JobVacancy data =new JobVacancy();
        data = jobVacancyService.getByDepartment(department);
        result.setData(data);
        result.setStatus(HttpStatus.FOUND.toString());
        result.setMethod(HttpMethod.GET.name());
        result.setMessage("Success");
        return result;
    }


}
