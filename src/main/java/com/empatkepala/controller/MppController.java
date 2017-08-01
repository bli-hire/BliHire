package com.empatkepala.controller;

import com.empatkepala.entity.Mpp;
import com.empatkepala.entity.request.AddMppRequest;
import com.empatkepala.entity.request.MppFormRequest;
import com.empatkepala.enumeration.Department;
import com.empatkepala.service.MppService;
import com.empatkepala.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by Juan on 3/11/17.
 */
@RestController
@RequestMapping(value = "/mpp")
public class MppController {
    @Autowired
    private MppService mppService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public void addMpp(
            @RequestBody AddMppRequest addMppRequest){
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
//
//
//        mppService.addMpp(mpp);
        mppService.addMpp(addMppRequest);

    }

//    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/{id}")
//    public void findMppById(@PathVariable Long id){
//        mppService.
//    }
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Collection<Mpp> findMppById(){
        return mppService.getAllMpp();
    }


    @RequestMapping(value = "/approve", method = RequestMethod.POST, produces = "application/json")
    public boolean approveMpp(@RequestBody Long idWhoApprove, Long MppId){
        return mppService.approveMpp(mppService.getMppById(MppId), userService.getUser(idWhoApprove));
    }

    @RequestMapping(value = "/reject", method = RequestMethod.POST, produces = "application/json")
    public boolean rejectMpp(@RequestBody Long idWhoReject, Long MppId){
        return mppService.rejectMpp(mppService.getMppById(MppId), userService.getUser(idWhoReject));

    }

    @RequestMapping(value = "/byDepartment", method = RequestMethod.GET, produces = "application/json")
    public Collection<Mpp> findByDepartment(@RequestHeader Department department){
        return mppService.getMppByDepartment(department);
    }

    @RequestMapping(value = "/requestedBy", method = RequestMethod.GET, produces = "application/json")
    public Collection<Mpp> findByRequestedBy(@RequestHeader Long userId){
        return mppService.getMppByRequestedBy(userService.getUser(userId));
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST, produces = "application/json")
    public boolean editMpp(@RequestBody MppFormRequest mppFormRequest, Long id, Long mppId){
        return mppService.editMpp(mppFormRequest, userService.getUser(id), mppService.getMppById(mppId));

    }




}
