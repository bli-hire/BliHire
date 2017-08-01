package com.empatkepala.service.impl;

import com.empatkepala.entity.Mpp;
import com.empatkepala.entity.User;
import com.empatkepala.entity.request.AddMppRequest;
import com.empatkepala.entity.request.MppFormRequest;
import com.empatkepala.enumeration.Department;
import com.empatkepala.repository.MppRepository;
import com.empatkepala.service.MppService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

/**
 * Created by Juan on 3/11/17.
 */
@Service
public class MppServiceImpl implements MppService{
    @Autowired
    MppRepository mppRepository;

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
    public void addMpp(Mpp mpp){
        mppRepository.save(mpp);
    }

    @Override
    public boolean approveMpp(Mpp mpp, User approver) {
        Mpp mppToApprove = mppRepository.findOne(mpp.getId());
        if(approver.getRole().getRoleName() == "CEO"){
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
        if(rejector.getRole().getRoleName() == "CEO"){
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
    public Collection<Mpp> getMppByRequestedBy(User requestedBy) {
        return mppRepository.findByRequestedBy(requestedBy);
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

    }


}
