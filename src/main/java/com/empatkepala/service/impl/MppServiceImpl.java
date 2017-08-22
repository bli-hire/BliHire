package com.empatkepala.service.impl;

import com.empatkepala.entity.Mpp;
import com.empatkepala.entity.MppDetail;
import com.empatkepala.entity.User;
import com.empatkepala.entity.request.AddMppRequest;
import com.empatkepala.entity.request.MppDetailRequest;
import com.empatkepala.enumeration.Department;
import com.empatkepala.enumeration.MppStatus;
import com.empatkepala.enumeration.Role;
import com.empatkepala.repository.MppDetailRepository;
import com.empatkepala.repository.MppRepository;
import com.empatkepala.service.MppService;
import com.empatkepala.service.UserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Juan on 3/11/17.
 */
@Service
public class MppServiceImpl implements MppService{
    @Autowired
    MppRepository mppRepository;

    @Autowired
    MppDetailRepository mppDetailRepository;

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

//    @Override
//    public void addMpp(@RequestBody MppFormRequest mppFormRequest)
//    {
//        Mpp mpp = new Mpp();
////        mpp.setApprovedBy(userService.getUser(mppFormRequest.getIdApprovedBy()));
//
//        mpp.setEducation(mppFormRequest.getEducation());
//        mpp.setEmployeeStatus(mppFormRequest.getEmployeeStatus());
//        mpp.setExpectedJoin(mppFormRequest.getExpectedJoin());
//        mpp.setExperience(mppFormRequest.getExperience());
//        mpp.setKnowledge(mppFormRequest.getKnowledge());
//        mpp.setMainResponsibility(mppFormRequest.getMainResponsibility());
//        mpp.setNumberOfPerson(mppFormRequest.getNumberOfPerson());
//        mpp.setPcAmmount(mppFormRequest.getPcAmmount());
//        mpp.setPcSpec(mppFormRequest.getPcSpec());
//        mpp.setReason(mppFormRequest.getReason());
//        mpp.setDepartment(userService.getUser((mppFormRequest.getIdRequestedBy())).getDepartment());
//        mpp.setRequestedBy(userService.getUser(mppFormRequest.getIdRequestedBy()));
//        mppRepository.save(mpp);
//    }

    @Override
    public boolean approveMpp(Mpp mpp, User approver) {
        Mpp mppToApprove = mppRepository.findOne(mpp.getId());
        if(approver.getRole() == Role.CEO){
            mppToApprove.setApprovedBy(approver);
            mppToApprove.setAccept(true);
            mppToApprove.setReject(false);
            mppToApprove.setMppStatus(MppStatus.accept_ceo);
            mppRepository.save(mppToApprove);
            return true;
        }
        return false;

    }

    @Override
    public boolean rejectMpp(Mpp mpp, User rejector) {
        Mpp mppToReject = mppRepository.findOne(mpp.getId());
        if(rejector.getRole() == Role.CEO){
//            mppToApprove.setApprovedBy(approver);
            mppToReject.setRejectedBy(rejector);
            mppToReject.setAccept(false);
            mppToReject.setReject(true);
            mppToReject.setMppStatus(MppStatus.reject_ceo);
            mppRepository.save(mppToReject);
            return true;
        }
        return false;

    }

    @Override
    public boolean approveHrdMpp(Mpp mpp, User approver) {
        Mpp mppToApprove = mppRepository.findOne(mpp.getId());
        if(approver.getRole() == Role.HeadHR || approver.getRole() == Role.HR){
            mppToApprove.setAcceptedHrdBy(approver);
            mppToApprove.setAcceptHrd(true);
            mppToApprove.setRejectHrd(false);
            mppToApprove.setMppStatus(MppStatus.accept_hrd);
            mppRepository.save(mppToApprove);
            return true;
        }
        return false;
    }

    @Override
    public boolean rejectHrdMpp(Mpp mpp, User rejector) {
        Mpp mppToReject = mppRepository.findOne(mpp.getId());
        if(rejector.getRole() == Role.HeadHR || rejector.getRole() == Role.HR){
//            mppToApprove.setApprovedBy(approver);
            mppToReject.setRejectedHrdBy(rejector);
            mppToReject.setAcceptHrd(false);
            mppToReject.setRejectHrd(true);
            mppToReject.setMppStatus(MppStatus.reject_hrd);
            mppRepository.save(mppToReject);
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
    public Collection<Mpp> getMppAcceptedByDepartmentNotPublished(Department department) {
        Collection<Mpp> mpps = new ArrayList<>();
        mpps.addAll(mppRepository.findByDepartmentAndAcceptAndRejectAndPublished(department,true,false, false));
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
//        return mppRepository.findByRequestedBy(requestedBy);
        return null;
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
    public Page<Mpp> getRejectedMppByRejectorAndDepartment(User rejector, Department department, Pageable pageable) {
        Page<Mpp> mpps = mppRepository.findByRejectedByAndDepartmentAndReject(rejector,department, true , pageable);
        return mpps;
    }

    @Override
    public Page<Mpp> getAcceptedMppByAcceptorAndDepartment(User acceptor, Department department, Pageable pageable) {
        Page<Mpp> mpps = mppRepository.findByApprovedByAndDepartmentAndAccept(acceptor, department, true, pageable);
        return mpps;
    }

    @Override
    public Page<Mpp> getRejectedMppByHrdRejectorAndDepartment(User rejectorHrd, Department department, Pageable pageable) {
        Page<Mpp> mpps = mppRepository.findByDepartmentAndRejectedHrdByAndRejectHrd(department, rejectorHrd, true, pageable);
        return mpps;
    }

    @Override
    public Page<Mpp> getAcceptedMppByHrdAcceptorAndDepartment(User acceptorHrd, Department department, Pageable pageable) {
        Page<Mpp> mpps = mppRepository.findByDepartmentAndAcceptedHrdByAndAcceptHrd(department, acceptorHrd, true, pageable);
        return mpps;
    }

    //untuk di proses hrd
    @Override
    public Page<Mpp> getMppToProccessedByHrdByDepartment(Department department, Pageable pageable) {
        Page<Mpp> mpps = mppRepository.findByDepartmentAndAcceptAndRejectAndAcceptHrdAndRejectHrd(department,false,false,false, false, pageable);
//        Page<Mpp> mpps = mppRepository.findByMppStatusAndDepartment(MppStatus.waiting_hrd, department,pageable);
        return mpps;
    }


    //untuk di proses CEO
    @Override
    public Page<Mpp> getMppToProccessedByCEOByDepartment(Department department, Pageable pageable) {
        Page<Mpp> mpps = mppRepository.findByDepartmentAndAcceptAndRejectAndAcceptHrdAndRejectHrd(department, false, false,true, false, pageable);
        return mpps;
    }

    @Override
    public Page<Mpp> getMppByMppStatusAndDepartment(Department department, Pageable pageable, MppStatus mppStatus) {
        Page<Mpp> mpps = mppRepository.findByMppStatusAndDepartment(mppStatus, department, pageable);
        return mpps;
    }

    @Override
    public Page<Mpp> getMppByMppStatusAndDepartmentAndProcessedBy(Department department, Pageable pageable, MppStatus mppStatus, User processor) {
        Page<Mpp> mpps;
        switch (mppStatus){
            case accept_ceo:
                mpps = mppRepository.findByMppStatusAndDepartmentAndApprovedBy(mppStatus, department, pageable, processor);
                return mpps;
            case reject_ceo:
                mpps = mppRepository.findByMppStatusAndDepartmentAndRejectedBy(mppStatus, department, pageable, processor);
                return  mpps;
            case accept_hrd:
                mpps = mppRepository.findByMppStatusAndDepartmentAndAcceptedHrdBy(mppStatus, department, pageable, processor);
                return  mpps;
            case reject_hrd:
                mpps = mppRepository.findByMppStatusAndDepartmentAndRejectedHrdBy(mppStatus, department, pageable, processor);
                return  mpps;
            case waiting_hrd:
                mpps = mppRepository.findByMppStatusAndRequestedBy(mppStatus, pageable, processor);
            default:
                return  null;
        }
    }

    @Override
    public Page<Mpp> getMppByRequestedByPendingStatus(User requestedBy, Pageable pageable) {
        List<MppStatus> listMppStatus = new ArrayList<>();
        listMppStatus.add(MppStatus.waiting_hrd);
        listMppStatus.add(MppStatus.accept_hrd);
        Page<Mpp> mpps = mppRepository.findByMppStatusInAndRequestedBy(listMppStatus ,requestedBy, pageable);
        return mpps;
    }

    @Override
    public Page<Mpp> getMppByRequestedByAcceptedStatus(User requestedBy, Pageable pageable) {
        Page<Mpp> mpps = mppRepository.findByMppStatusAndRequestedBy(MppStatus.accept_ceo, pageable, requestedBy);
        return mpps;
    }

    @Override
    public Page<Mpp> getMppByRequestedByRejectedStatus(User requestedBy, Pageable pageable) {
        List<MppStatus> listMppStatus = new ArrayList<>();
        listMppStatus.add(MppStatus.reject_ceo);
        listMppStatus.add(MppStatus.reject_hrd);
        Page<Mpp> mpps = mppRepository.findByMppStatusInAndRequestedBy(listMppStatus, requestedBy, pageable);
        return mpps;
    }


    @Override
    public Collection<Mpp> getPublishedMppByDepartment(Department department) {
        Collection<Mpp> mpps = new ArrayList<>();
        mpps.addAll(mppRepository.findByDepartmentAndPublished(department, true));
        return mpps;
    }


//    @Override
//    public boolean editMpp(MppFormRequest mppFormRequest, User editor, Mpp mppToEdit) {
//        if(editor.getId() == mppFormRequest.getIdRequestedBy()){
//            Mpp preparedMpp = mppRepository.findOne(mppToEdit.getId());
////            preparedMpp.setEducation(mppFormRequest.getEducation());
////            preparedMpp.setEmployeeStatus(mppFormRequest.getEmployeeStatus());
////            preparedMpp.setExpectedJoin(mppFormRequest.getExpectedJoin());
////            preparedMpp.setExperience(mppFormRequest.getExperience());
////            preparedMpp.setKnowledge(mppFormRequest.getKnowledge());
////            preparedMpp.setMainResponsibility(mppFormRequest.getMainResponsibility());
////            preparedMpp.setNumberOfPerson(mppFormRequest.getNumberOfPerson());
////            preparedMpp.setPcAmmount(mppFormRequest.getPcAmmount());
////            preparedMpp.setPcSpec(mppFormRequest.getPcSpec());
////            preparedMpp.setReason(mppFormRequest.getReason());
//
//            mppRepository.save(preparedMpp);
//            return true;
//        }
//
//        return false;
//
//    }

    @Override
    public void addMpp(@RequestBody AddMppRequest addMppRequest) {
//        Mpp input = new Mpp(addMppRequest.getPosition(), addMppRequest.getNumberOfPerson(),
//                addMppRequest.getReason(), addMppRequest.getMainResponsibility(),
//                addMppRequest.getEducation(), addMppRequest.getExperience(),
//                addMppRequest.getKnowledge(), addMppRequest.getEmployeeStatus(),
//                addMppRequest.getExpectedJoin(), addMppRequest.getPcAmmount(),
//                addMppRequest.getPcSpec(), userService.getUser(addMppRequest.getIdRequested()), userService.getUser(addMppRequest.getIdRequested()).getDepartment());
        Mpp input = new Mpp(userService.getUser(addMppRequest.getIdRequested()), userService.getUser(addMppRequest.getIdRequested()).getDepartment());


//        Collection<MppDetail> mppDetails = new ArrayList<>();
        Mpp mpp = mppRepository.save(input);

        for(MppDetailRequest mppDetailRequest : addMppRequest.getMppDetails()){
            MppDetail mppDetailBaru = new MppDetail(mppDetailRequest.getPosition(), mppDetailRequest.getNumberOfPerson(),
                    mppDetailRequest.getReason(), mppDetailRequest.getMainResponsibility(), mppDetailRequest.getEducation(),
                    mppDetailRequest.getExperience(), mppDetailRequest.getKnowledge(), mppDetailRequest.getEmployeeStatus(),
                    mppDetailRequest.getExpectedJoin(), mppDetailRequest.getPcAmmount(), mppDetailRequest.getPcSpec(), mpp);

            mppDetailBaru.setJanuaryExpect(mppDetailRequest.getExpectJoin().getJanuaryExpect());
            mppDetailBaru.setFebruaryExpect(mppDetailRequest.getExpectJoin().getFebruaryExpect());
            mppDetailBaru.setMarchExpect(mppDetailRequest.getExpectJoin().getMarchExpect());
            mppDetailBaru.setAprilExpect(mppDetailRequest.getExpectJoin().getAprilExpect());
            mppDetailBaru.setMayExpect(mppDetailRequest.getExpectJoin().getMayExpect());
            mppDetailBaru.setJuneExpect(mppDetailRequest.getExpectJoin().getJuneExpect());

            mppDetailBaru.setJulyExpect(mppDetailRequest.getExpectJoin().getJulyExpect());
            mppDetailBaru.setAugustExpect(mppDetailRequest.getExpectJoin().getAugustExpect());
            mppDetailBaru.setSeptemberExpect(mppDetailRequest.getExpectJoin().getSeptemberExpect());
            mppDetailBaru.setOctoberExpect(mppDetailRequest.getExpectJoin().getOctoberExpect());
            mppDetailBaru.setNovemberExpect(mppDetailRequest.getExpectJoin().getNovemberExpect());
            mppDetailBaru.setDecemberExpect(mppDetailRequest.getExpectJoin().getDecemberExpect());

            mppDetailBaru.setExpectedJoinAndNumberOfPersonTotal();
            mppDetailRepository.save(mppDetailBaru);
        }



    }

    @Override
    public boolean publishMpp(Mpp mpp, User whoPublish) {
        if((whoPublish.getRole() == Role.HR || whoPublish.getRole() == Role.HeadHR) && mppRepository.getOne(mpp.getId()).isAccept() == true ){
            Mpp mppToPublish = mppRepository.getOne(mpp.getId());
            mppToPublish.setPublished(true);
            mppToPublish.setPublishedBy(whoPublish);
            mppRepository.save(mppToPublish);
            return true;
        }
        return false;
    }


}
