package com.empatkepala.service.impl;

import com.empatkepala.entity.Mpp;
import com.empatkepala.entity.User;
import com.empatkepala.entity.request.AddMppRequest;
import com.empatkepala.entity.request.MppFormRequest;
import com.empatkepala.enumeration.Department;
import com.empatkepala.enumeration.Role;
import com.empatkepala.repository.MppRepository;
import com.empatkepala.service.MppService;
import com.empatkepala.service.UserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Juan on 3/11/17.
 */
@Service
public class MppServiceImpl implements MppService{
    @Autowired
    MppRepository mppRepository;

    @Autowired
    UserService userService;

//    public User getUserByRequestedBy(User user){
//
//        Mpp mpp = mppRepository.findOne(1L);
//        Hibernate.initialize(mpp.getRequestedBy());
//        return mpp.getRequestedBy();
//    }

    @Override
    public User getRequestedByByMppId(Long id){

        Mpp mpp = mppRepository.findOne(id);
//        Hibernate.initialize(mpp.getRequestedBy());
        return mpp.getRequestedBy();
    }

    @Override
    public Mpp getMppById(Long id){
        return mppRepository.findOne(id);
    }

    @Override
    public Collection<Mpp> getAllMpp(){
        return mppRepository.findAll();
    }

    @Override
    public void addMpp(@RequestBody MppFormRequest mppFormRequest)
    {
        Mpp mpp = new Mpp();
//        mpp.setApprovedBy(userService.getUser(mppFormRequest.getIdApprovedBy()));

        mpp.setEducation(mppFormRequest.getEducation());
        mpp.setEmployeeStatus(mppFormRequest.getEmployeeStatus());
        mpp.setExpectedJoin(mppFormRequest.getExpectedJoin());
        mpp.setExperience(mppFormRequest.getExperience());
        mpp.setKnowledge(mppFormRequest.getKnowledge());
        mpp.setMainResponsibility(mppFormRequest.getMainResponsibility());
        mpp.setNumberOfPerson(mppFormRequest.getNumberOfPerson());
        mpp.setPcAmmount(mppFormRequest.getPcAmmount());
        mpp.setPcSpec(mppFormRequest.getPcSpec());
        mpp.setReason(mppFormRequest.getReason());
        mpp.setDepartment(userService.getUser((mppFormRequest.getIdRequestedBy())).getDepartment());
        mpp.setRequestedBy(userService.getUser(mppFormRequest.getIdRequestedBy()));
        mppRepository.save(mpp);
    }

    @Override
    public boolean approveMpp(Mpp mpp, User approver) {
        Mpp mppToApprove = mppRepository.findOne(mpp.getId());
        if(approver.getRole() == Role.CEO){
            mppToApprove.setApprovedBy(approver);
            mppToApprove.setAccept(true);
            mppToApprove.setReject(false);
            mppRepository.save(mppToApprove);
            return true;
        }
        return false;

    }

    @Override
    public boolean rejectMpp(Mpp mpp, User rejector) {
        Mpp mppToApprove = mppRepository.findOne(mpp.getId());
        if(rejector.getRole() == Role.CEO){
//            mppToApprove.setApprovedBy(approver);
            mppToApprove.setAccept(false);
            mppToApprove.setReject(true);
            mppRepository.save(mppToApprove);
            return true;
        }
        return false;

    }

    @Override
    public Collection<Mpp> getMppByDepartment(Department department) {
        return mppRepository.findByDepartment(department);
    }

    @Override
    public Collection<Mpp> getMppHistoryByDepartment(Department department) {
        Collection<Mpp> mpps = new ArrayList<>();
        mpps.addAll(mppRepository.findByDepartmentAndAcceptAndReject(department,true,false));
        mpps.addAll(mppRepository.findByDepartmentAndAcceptAndReject(department,false,true));
        return mpps;

    }

    @Override
    public Collection<Mpp> getMppAcceptedByDepartment(Department department) {
        Collection<Mpp> mpps = new ArrayList<>();
        mpps.addAll(mppRepository.findByDepartmentAndAcceptAndReject(department,true,false));
        return mpps;

    }

    @Override
    public Collection<Mpp> getMppActiveByDepartment(Department department) {
        Collection<Mpp> mpps = new ArrayList<>();
        mpps.addAll(mppRepository.findByDepartmentAndAcceptAndReject(department,false,false));
        return mpps;
    }

    @Override
    public Collection<Mpp> getMppByRequestedBy(User requestedBy) {
        return mppRepository.findByRequestedBy(requestedBy);
    }

    @Override
    public Collection<Mpp> getMppByRequestedByPending(User requestedBy) {
        Collection<Mpp> mpps = new ArrayList<>();
        mpps.addAll(mppRepository.findByRequestedByAndAcceptAndReject(requestedBy,false,false));
        return mpps;
    }

    @Override
    public Collection<Mpp> getMppByRequestedByAccepted(User requestedBy) {
        Collection<Mpp> mpps = new ArrayList<>();
        mpps.addAll(mppRepository.findByRequestedByAndAcceptAndReject(requestedBy,true,false));
        return mpps;
    }

    @Override
    public Collection<Mpp> getMppByRequestedByRejected(User requestedBy) {
        Collection<Mpp> mpps = new ArrayList<>();
        mpps.addAll(mppRepository.findByRequestedByAndAcceptAndReject(requestedBy,false,true));
        return mpps;
    }


    @Override
    public boolean editMpp(MppFormRequest mppFormRequest, User editor, Mpp mppToEdit) {
        if(editor.getId() == mppFormRequest.getIdRequestedBy()){
            Mpp preparedMpp = mppRepository.findOne(mppToEdit.getId());
            preparedMpp.setEducation(mppFormRequest.getEducation());
            preparedMpp.setEmployeeStatus(mppFormRequest.getEmployeeStatus());
            preparedMpp.setExpectedJoin(mppFormRequest.getExpectedJoin());
            preparedMpp.setExperience(mppFormRequest.getExperience());
            preparedMpp.setKnowledge(mppFormRequest.getKnowledge());
            preparedMpp.setMainResponsibility(mppFormRequest.getMainResponsibility());
            preparedMpp.setNumberOfPerson(mppFormRequest.getNumberOfPerson());
            preparedMpp.setPcAmmount(mppFormRequest.getPcAmmount());
            preparedMpp.setPcSpec(mppFormRequest.getPcSpec());
            preparedMpp.setReason(mppFormRequest.getReason());

            mppRepository.save(preparedMpp);
            return true;
        }

        return false;

    }

    @Override
    public void addMpp(@RequestBody AddMppRequest addMppRequest) {
        Mpp input = new Mpp(addMppRequest.getPosition(), addMppRequest.getNumberOfPerson(),
                addMppRequest.getReason(), addMppRequest.getMainResponsibility(),
                addMppRequest.getEducation(), addMppRequest.getExperience(),
                addMppRequest.getKnowledge(), addMppRequest.getEmployeeStatus(),
                addMppRequest.getExpectedJoin(), addMppRequest.getPcAmmount(),
                addMppRequest.getPcSpec(), userService.getUser(addMppRequest.getIdRequested()), userService.getUser(addMppRequest.getIdRequested()).getDepartment());
        input.setJanuaryExpect(addMppRequest.getExpectJoin().getJanuaryExpect());
        input.setFebruaryExpect(addMppRequest.getExpectJoin().getFebruaryExpect());
        input.setMarchExpect(addMppRequest.getExpectJoin().getMarchExpect());
        input.setAprilExpect(addMppRequest.getExpectJoin().getAprilExpect());
        input.setMayExpect(addMppRequest.getExpectJoin().getMayExpect());
        input.setJuneExpect(addMppRequest.getExpectJoin().getJuneExpect());

        input.setJulyExpect(addMppRequest.getExpectJoin().getJulyExpect());
        input.setAugustExpect(addMppRequest.getExpectJoin().getAugustExpect());
        input.setSeptemberExpect(addMppRequest.getExpectJoin().getSeptemberExpect());
        input.setOctoberExpect(addMppRequest.getExpectJoin().getOctoberExpect());
        input.setNovemberExpect(addMppRequest.getExpectJoin().getNovemberExpect());
        input.setDecemberExpect(addMppRequest.getExpectJoin().getDecemberExpect());


        mppRepository.save(input);
    }


}
