package com.empatkepala.controller;

import com.empatkepala.entity.JobVacancy;
import com.empatkepala.entity.response.JobVacancyResponse;
import com.empatkepala.enumeration.Department;
import com.empatkepala.service.JobVacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Ryan Bagus Susilo on 8/8/2017.
 */
@RestController
@RequestMapping(value="/jobVacancy")
@CrossOrigin(origins = "*")
public class JobVacancyController {
    @Autowired
    JobVacancyService jobVacancyService;

    @RequestMapping(value = "/getByDepartment", method= RequestMethod.GET)
    public JobVacancyResponse getAllJobVacancyByDepartment(@RequestHeader Department department) {
        JobVacancyResponse result = new JobVacancyResponse();
        Collection<JobVacancy> data = new ArrayList<>();
        data = jobVacancyService.getByDepartment(department);
        result.setData(data);
        result.setStatus(HttpStatus.FOUND.toString());
        result.setMethod(HttpMethod.GET.name());
        result.setMessage("Success");
        return result;
    }

    @RequestMapping(value = "/getAll",method= RequestMethod.GET)
    public JobVacancyResponse getAll() {
        JobVacancyResponse result = new JobVacancyResponse();
        Collection<JobVacancy> data = new ArrayList<>();
        data = jobVacancyService.getAll();
        result.setData(data);
        result.setStatus(HttpStatus.FOUND.toString());
        result.setMethod(HttpMethod.GET.name());
        result.setMessage("Success");
        return result;
    }

    @RequestMapping(value = "/updateStatusApplicant", method = RequestMethod.POST)
    public JobVacancyResponse getAllJobVacancyByAddPersonNeeded(@RequestHeader Department department,@RequestHeader int personNeeded,@RequestHeader String position) {
        try{
            jobVacancyService.addPersonNeeded(department, personNeeded, position);
            return new JobVacancyResponse(HttpStatus.ACCEPTED.toString(),"Success get Data Person Needed",null,HttpMethod.GET.toString());
        }catch (Exception ex){
            return new JobVacancyResponse(HttpStatus.NOT_ACCEPTABLE.toString(),ex.getMessage(),null, HttpMethod.GET.toString());
        }

    }




}
