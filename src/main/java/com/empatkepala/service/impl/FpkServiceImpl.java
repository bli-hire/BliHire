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
import org.joda.time.DateTime;
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
        result.addAll(getFpkAcceptedByDepartment(department));
        result.addAll(getFpkRejectedByDepartment(department));
        return result;
    }

    @Override
    public Collection<Fpk> getFpkActiveByDepartment(Department department) {
        List<Fpk> result = new ArrayList<>();
        result.addAll(fpkRepository.findByDepartmentAndAcceptAndReject(department,false,false));
        return result;
    }

    @Override
    public Collection<Fpk> getFpkAcceptedByDepartment(Department department) {
        List<Fpk> result = new ArrayList<>();
        result.addAll(fpkRepository.findByDepartmentAndAcceptAndReject(department,true,false));
        return result;
    }

    @Override
    public Collection<Fpk> getFpkRejectedByDepartment(Department department) {
        List<Fpk> result = new ArrayList<>();
        result.addAll(fpkRepository.findByDepartmentAndAcceptAndReject(department,false,true));
        return result;
    }

    @Override
    public Collection<Fpk> getFpkPendingByDepartment(Department department) {
        List<Fpk> result = new ArrayList<>();
        result.addAll(fpkRepository.findByDepartmentAndAcceptAndReject(department,false,false));
        return result;
    }

    public List getAllData(){
        return fpkRepository.findAll();
    }

    @Override
    public Fpk getFpk(long id) {return fpkRepository.findOne(id);}

    public void addFpk(@RequestBody AddFpkRequest addFpkRequest, boolean approveHead){

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
                new DateTime(addFpkRequest.getDateNeeded()),
                addFpkRequest.getJobPositionRequester()
        );
        input.setApproveHead(approveHead);
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
        if(approver.getRole() == Role.HR || approver.getRole() == Role.HeadHR){
            fpkToApprove.setAccept(true);
            fpkRepository.save(fpkToApprove);
            return true;
        } else if (approver.getRole() == Role.DepartmentHead) {
            fpkToApprove.setApproveHead(true);
            fpkRepository.save(fpkToApprove);
            return true;
        } else if (approver.getRole() == Role.CEO ) {
            fpkToApprove.setApproveCeo(true);
            fpkRepository.save(fpkToApprove);
            return true;
        }
        return false;
    }

    @Override
    public boolean rejectFpk(Fpk fpk, User rejecter) {
        Fpk fpkToReject = fpkRepository.findOne(fpk.getIdFpk());
        if(rejecter.getRole() == Role.HR || rejecter.getRole() == Role.HeadHR ){
            fpkToReject.setAccept(false);
            fpkRepository.save(fpkToReject);
            return true;
        } else if (rejecter.getRole() == Role.CEO) {
            fpkToReject.setApproveCeo(false);
            fpkRepository.save(fpkToReject);
            return true;
        } else if (rejecter.getRole() == Role.DepartmentHead) {
            fpkToReject.setApproveHead(false);
            fpkRepository.save(fpkToReject);;
            return true;
        }
        return false;
    }
}
