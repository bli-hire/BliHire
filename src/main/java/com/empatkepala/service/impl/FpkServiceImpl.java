package com.empatkepala.service.impl;

import com.empatkepala.entity.Fpk;
import com.empatkepala.entity.User;
import com.empatkepala.entity.request.AddFpkRequest;
import com.empatkepala.repository.FpkRepository;
import com.empatkepala.repository.UserRepository;
import com.empatkepala.service.FpkService;
import com.empatkepala.service.UserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Iterator;
import java.util.List;

/**
 * Created by ALz on 3/11/2017.
 */

@Service
public class FpkServiceImpl implements FpkService{
    @Autowired
    FpkRepository fpkRepository;

    @Autowired
    UserService userService;

    public List getAllData(){
        return fpkRepository.findAll();
    }

    @Override
    public Fpk getFpk(Long id) {return fpkRepository.findOne(id);}

    public void addFpk(@RequestBody AddFpkRequest addFpkRequest){

        Fpk input = new Fpk(addFpkRequest.getPosition(),
                addFpkRequest.getReason(),
                addFpkRequest.getFitnessWithMpp(),
                addFpkRequest.getEmployeeStatus(),
                addFpkRequest.getSchool(),
                addFpkRequest.getWorkExperience(),
                addFpkRequest.getSkillKnowledge(),
                addFpkRequest.getCompleteness(),
                userService.getUser(addFpkRequest.getIdUserRequested()),
                userService.getUser(addFpkRequest.getIdUserApproved())
        );

        fpkRepository.save(input);
    }

    public void update(Fpk data){
        fpkRepository.save(data);
    }

    @Override
    public void delete(Long id) {fpkRepository.delete(id);}

    public User getRequestUserByFpk(Long id) {
        Fpk fpk = fpkRepository.findOne(id);
//        Hibernate.initialize(user);
        return fpk.getRequestedBy();
    }

    public User getApprovedUserByFpk(Long id) {
        Fpk fpk = fpkRepository.findOne(id);
//        Hibernate.initialize(user);
        return fpk.getRequestedBy();
    }
}
