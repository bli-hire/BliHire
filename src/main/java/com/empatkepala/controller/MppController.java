package com.empatkepala.controller;

import com.empatkepala.entity.Mpp;
import com.empatkepala.entity.request.MppFormRequest;
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
            @RequestBody MppFormRequest mppFormRequest){
        Mpp mpp = new Mpp();
        mpp.setApprovedBy(userService.getUser(mppFormRequest.getIdApprovedBy()));

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

        mpp.setRequestedBy(userService.getUser(mppFormRequest.getIdRequestedBy()));

        mppService.addMpp(mpp);

    }

//    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/{id}")
//    public void findMppById(@PathVariable Long id){
//        mppService.
//    }
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Collection<Mpp> findMppById(){
        return mppService.getAllMpp();
    }


}
