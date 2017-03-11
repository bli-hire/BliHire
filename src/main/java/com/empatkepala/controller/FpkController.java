package com.empatkepala.controller;

import com.empatkepala.entity.Fpk;
import com.empatkepala.entity.User;
import com.empatkepala.entity.request.AddFpkRequest;
import com.empatkepala.repository.FpkRepository;
import com.empatkepala.service.FpkService;
import com.empatkepala.service.impl.FpkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ALz on 3/11/2017.
 */
@RestController(value="/internal/fpk")
public class FpkController {
    @Autowired
    FpkService fpkService;


    @RequestMapping(method = RequestMethod.GET,produces = "application/json")
    public List getAllFpk(){
        return fpkService.getAllData();
    }

    @RequestMapping(method = RequestMethod.POST,produces = "application/json")
    public void insertFpk(
            @RequestBody
                    AddFpkRequest addFpkRequest
            ){
        Fpk input =
                new Fpk(addFpkRequest.getPosition(),
                        addFpkRequest.getReason(),
                        addFpkRequest.getFitnessWithMpp(),
                        addFpkRequest.getEmployeeStatus(),
                        addFpkRequest.getSchool(),
                        addFpkRequest.getWorkExperience(),
                        addFpkRequest.getSkillKnowledge(),
                        addFpkRequest.getCompleteness(),
                        fpkService.getUser(addFpkRequest.getIdUserRequested()),
                        fpkService.getUser(addFpkRequest.getIdUserApproved())
                        );
        fpkService.save(input);
    }

    @RequestMapping(method = RequestMethod.PUT,produces = "application/json")
    public void updateFpk(Fpk findOne){
        fpkService.update(findOne);
    }
}
