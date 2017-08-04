package com.empatkepala.controller;

import com.empatkepala.entity.Mpp;
import com.empatkepala.entity.request.AddMppRequest;
import com.empatkepala.entity.request.ApproveRejectMppRequest;
import com.empatkepala.entity.request.MppFormRequest;
import com.empatkepala.entity.response.MppResponse;
import com.empatkepala.enumeration.Department;
import com.empatkepala.service.MppService;
import com.empatkepala.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Juan on 3/11/17.
 */
@RestController
@RequestMapping(value = "/mpp")
@CrossOrigin(origins = "*")
public class MppController {
    @Autowired
    private MppService mppService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public MppResponse addMpp(
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
        return new MppResponse(HttpStatus.ACCEPTED.toString(),"Success Add Mpp",null, 1, "POST", addMppRequest.getRequestBody(), addMppRequest.getHeaderContentType());

    }

//    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/{id}")
//    public void findMppById(@PathVariable Long id){
//        mppService.
//    }
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Collection<Mpp> findAll(){
        return mppService.getAllMpp();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET, produces = "application/json")
    public MppResponse findById(@PathVariable Long id){
//        return mppService.getMppById(id);
        Mpp mpp = mppService.getMppById(id);
        Collection<Mpp> data = new ArrayList<>();
        data.add(mpp);
        return new MppResponse(HttpStatus.FOUND.toString(), "Success Get Mpp By Id", data, data.size());

    }


    @RequestMapping(value = "/approve", method = RequestMethod.POST, produces = "application/json")
    public MppResponse approveMpp(@RequestBody ApproveRejectMppRequest approveRejectMppRequest){
//        try {
//            if(mppService.approveMpp(mppService.getMppById(approveRejectMppRequest.getIdMpp()), userService.getUser(approveRejectMppRequest.getIdUser()))){
//                return new MppResponse("Sukses Approve", "Success Approve Mpp", null);
//
//            }
//            else{
//                return new MppResponse("gagal","gagal approve",null);
//
//            }
//        }catch(Exception ex){
//            return new MppResponse(ex.toString(),ex.getStackTrace().toString(),null);
//        }
        if(mppService.approveMpp(mppService.getMppById(approveRejectMppRequest.getIdMpp()), userService.getUser(approveRejectMppRequest.getIdUser())) == true){
            return new MppResponse(HttpStatus.ACCEPTED.toString(), "Success Approve Mpp", null);

        }
        else{
            return new MppResponse(HttpStatus.ACCEPTED.toString(), "Gagal", null);

        }
//        return mppService.approveMpp(mppService.getMppById(MppId), userService.getUser(idWhoApprove));
    }

    @RequestMapping(value = "/reject", method = RequestMethod.POST, produces = "application/json")
    public MppResponse rejectMpp(@RequestBody ApproveRejectMppRequest approveRejectMppRequest){
        if(mppService.rejectMpp(mppService.getMppById(approveRejectMppRequest.getIdMpp()), userService.getUser(approveRejectMppRequest.getIdUser())) == true){
            return new MppResponse(HttpStatus.ACCEPTED.toString(), "Success Reject Mpp", null);

        }
        else{
            return new MppResponse(HttpStatus.ACCEPTED.toString(), "Gagal", null);

        }

    }

    @RequestMapping(value = "/byDepartment", method = RequestMethod.GET, produces = "application/json")
    public MppResponse findByDepartment(@RequestHeader Department department){
        Collection<Mpp> data = mppService.getMppByDepartment(department);
//        return mppService.getMppByDepartment(department);
        return new MppResponse(HttpStatus.FOUND.toString(),"Success Get Mpp By Department",data,data.size());
    }
    @RequestMapping(value = "/byDepartment/active", method = RequestMethod.GET, produces = "application/json")
    public MppResponse findMppByDepartmentActive(@RequestHeader Department department){
        Collection<Mpp> data = mppService.getMppActiveByDepartment(department);
        return new MppResponse(HttpStatus.FOUND.toString(),"Success Get Mpp By Department",data,data.size());
    }


    @RequestMapping(value = "/byDepartment/history", method = RequestMethod.GET, produces = "application/json")
    public MppResponse findMppByDepartmentHistory(@RequestHeader Department department){
        Collection<Mpp> data = mppService.getMppHistoryByDepartment(department);
        return new MppResponse(HttpStatus.FOUND.toString(),"Success Get Mpp By Department",data,data.size());
    }

    @RequestMapping(value = "/byDepartment/accepted", method = RequestMethod.GET, produces = "application/json")
    public MppResponse findMppByDepartmentAccepted(@RequestHeader Department department){
        Collection<Mpp> data = mppService.getMppAcceptedByDepartment(department);
        return new MppResponse(HttpStatus.FOUND.toString(),"Success Get Accepted Mpp By Department",data,data.size());
    }

    @RequestMapping(value = "/requestedBy", method = RequestMethod.GET, produces = "application/json")
    public MppResponse findByRequestedBy(@RequestHeader Long userId){
        Collection<Mpp> data = mppService.getMppByRequestedBy(userService.getUser(userId));
        return new MppResponse(HttpStatus.FOUND.toString(),"Success Get Mpp By Requested",data,data.size());

//        return mppService.getMppByRequestedBy(userService.getUser(userId));
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST, produces = "application/json")
    public MppResponse editMpp(@RequestBody MppFormRequest mppFormRequest, Long id, Long mppId){
        mppService.editMpp(mppFormRequest, userService.getUser(id), mppService.getMppById(mppId));
        return new MppResponse(HttpStatus.ACCEPTED.toString(),"Success Edit Mpp",null);

//        return mppService.editMpp(mppFormRequest, userService.getUser(id), mppService.getMppById(mppId));

    }

    @RequestMapping(value = "/byRequested/pending", method = RequestMethod.GET, produces = "application/json")
    public MppResponse findMppByRequestedPending(@RequestHeader Long userId){
        Collection<Mpp> data = mppService.getMppByRequestedByPending(userService.getUser(userId));
        return new MppResponse(HttpStatus.FOUND.toString(),"Success Get Mpp By Requested",data,data.size());
    }

    @RequestMapping(value = "/byRequested/accepted", method = RequestMethod.GET, produces = "application/json")
    public MppResponse findMppByRequestedAccepted(@RequestHeader Long userId){
        Collection<Mpp> data = mppService.getMppByRequestedByAccepted(userService.getUser(userId));
        return new MppResponse(HttpStatus.FOUND.toString(),"Success Get Mpp By Requested",data,data.size());
    }

    @RequestMapping(value = "/byRequested/rejected", method = RequestMethod.GET, produces = "application/json")
    public MppResponse findMppByRequestedRejected(@RequestHeader Long userId){
        Collection<Mpp> data = mppService.getMppByRequestedByRejected(userService.getUser(userId));
        return new MppResponse(HttpStatus.FOUND.toString(),"Success Get Mpp By Requested",data,data.size());
    }

    @RequestMapping(value = "/byDepartment/accepted/ceo", method = RequestMethod.GET, produces = "application/json")
    public MppResponse findAcceptedMppByAcceptorAndDepartment(@RequestHeader Long userId, @RequestHeader Department department){
        Collection<Mpp> data = mppService.getAcceptedMppByAcceptorAndDepartment(userService.getUser(userId), department);
        return new MppResponse(HttpStatus.FOUND.toString(),"Success Get Accepted Mpp By Acceptor",data,data.size());
    }

    @RequestMapping(value = "/byDepartment/rejected/ceo", method = RequestMethod.GET, produces = "application/json")
    public MppResponse findRejectedMppByRejectorAndDepartment(@RequestHeader Long userId, @RequestHeader Department department){
        Collection<Mpp> data = mppService.getRejectedMppByRejectorAndDepartment(userService.getUser(userId), department);
        return new MppResponse(HttpStatus.FOUND.toString(),"Success Get Rejected Mpp By Rejector",data,data.size());
    }




}
