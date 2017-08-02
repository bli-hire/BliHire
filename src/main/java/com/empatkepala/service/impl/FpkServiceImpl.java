package com.empatkepala.service.impl;

import com.empatkepala.entity.Fpk;
import com.empatkepala.entity.User;
import com.empatkepala.entity.request.AddFpkRequest;
import com.empatkepala.enumeration.Department;
import com.empatkepala.enumeration.Role;
import com.empatkepala.repository.FpkRepository;
import com.empatkepala.repository.UserRepository;
import com.empatkepala.service.FpkService;
import com.empatkepala.service.UserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Collection;
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

    @Override
    public Collection<Fpk> getFpkByDepartment(Department department) {
        return fpkRepository.findByDepartment(department);
    }

    @Override
    public Collection<Fpk> getFpkByRequestedBy(User requestedBy) {
        return fpkRepository.findByRequestedBy(requestedBy);
    }

    @Override
    public Collection<Fpk> getFpkHistoryByDepartment(Department department) {
        List<Fpk> result = new ArrayList<>();
        result.addAll(fpkRepository.findByDepartmentAndAcceptAndReject(department,true,false));
        result.addAll(fpkRepository.findByDepartmentAndAcceptAndReject(department,false,true));
        return result;
    }

    @Override
    public Collection<Fpk> getFpkActiveByDepartment(Department department) {
        List<Fpk> result = new ArrayList<>();
        result.addAll(fpkRepository.findByDepartmentAndAcceptAndReject(department,false,false));
        return result;
    }

    public List getAllData(){
        return fpkRepository.findAll();
    }

    @Override
    public Fpk getFpk(long id) {return fpkRepository.findOne(id);}

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
                userService.getUser(addFpkRequest.getIdUserRequested()).getDepartment(),
                addFpkRequest.getDateNeeded(),
                addFpkRequest.getJobPositionRequester()
        );

        fpkRepository.save(input);
    }

    public User getRequestUserByFpkId(Long id) {
        Fpk fpk = fpkRepository.findOne(id);
//        Hibernate.initialize(user);
        return fpk.getRequestedBy();
    }

    public User getApprovedUserByFpk(Long id) {
        Fpk fpk = fpkRepository.findOne(id);
//        Hibernate.initialize(user);
        return fpk.getRequestedBy();
    }


    @Override
    public boolean editFpk(AddFpkRequest fpkRequest, User editor, Fpk fpkToEdit) {
        if(editor.getId() == fpkRequest.getIdUserRequested()){
            Fpk updatedFpk = fpkRepository.findOne((fpkToEdit.getIdFpk()));
            updatedFpk.setReason(fpkRequest.getReason());
            updatedFpk.setEmployeeStatus(fpkRequest.getEmployeeStatus());
            updatedFpk.setFitnessWithMpp(fpkRequest.getFitnessWithMpp());
            updatedFpk.setNumberOfPerson(fpkRequest.getPosition());
            updatedFpk.setSchool(fpkRequest.getSchool());
            updatedFpk.setSkillKnowledge(fpkRequest.getSkillKnowledge());
            updatedFpk.setWorkExperience(fpkRequest.getWorkExperience());
            updatedFpk.setCompleteness(fpkRequest.getCompleteness());

            fpkRepository.save(updatedFpk);
            return true;
        }
        return false;
    }

    @Override
    public boolean approveFpk(Fpk fpk, User approver) {
        Fpk fpkToApprove = fpkRepository.findOne(fpk.getIdFpk());
        if(approver.getRole() == Role.CEO || approver.getRole() == Role.HR){
            fpkToApprove.setAccept(true);
            fpkToApprove.setReject(false);
            fpkRepository.save(fpkToApprove);
            return true;
        }
        return false;
    }

    @Override
    public boolean rejectFpk(Fpk fpk, User rejecter) {
        Fpk fpkToApprove = fpkRepository.findOne(fpk.getIdFpk());
        if(rejecter.getRole() == Role.CEO || rejecter.getRole() == Role.HR){
            fpkToApprove.setAccept(false);
            fpkToApprove.setReject(true);
            fpkRepository.save(fpkToApprove);
            return true;
        }
        return false;
    }
}
