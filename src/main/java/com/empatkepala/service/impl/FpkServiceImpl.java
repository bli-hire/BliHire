package com.empatkepala.service.impl;

import com.empatkepala.entity.Fpk;
import com.empatkepala.entity.User;
import com.empatkepala.entity.request.AddFpkRequest;
import com.empatkepala.enumeration.Department;
import com.empatkepala.repository.FpkRepository;
import com.empatkepala.repository.UserRepository;
import com.empatkepala.service.FpkService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Collection<Fpk> getFpkByDepartment(Department department) {
        return fpkRepository.findByDepartment(department);
    }

    @Override
    public Collection<Fpk> getFpkByRequestedUser(User userRequested) {
        return fpkRepository.findByRequestedBy(userRequested);
    }

    public List getAllData(){
        return fpkRepository.findAll();
    }

    @Override
    public Fpk getFpk(Long id) {return fpkRepository.findOne(id);}

    public void save(Fpk data){
        fpkRepository.save(data);
    }

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

    @Override
    public User getRequestedUserByFpkId(Long id) {
        Fpk fpk = fpkRepository.findOne(id);
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
        if(approver.getRole().getRoleName() == "CEO" || approver.getRole().getRoleName() == "HR"){
            fpkToApprove.setAccept(true);
            fpkToApprove.setReject(false);
        }
        return false;
    }

    @Override
    public boolean rejectFpk(Fpk fpk, User rejecter) {
        Fpk fpkToApprove = fpkRepository.findOne(fpk.getIdFpk());
        if(rejecter.getRole().getRoleName() == "CEO" || rejecter.getRole().getRoleName() == "HR"){
            fpkToApprove.setAccept(false);
            fpkToApprove.setReject(true);
        }
        return false;
    }
}
