package com.empatkepala.controller;

import com.empatkepala.entity.Fpk;
import com.empatkepala.entity.User;
import com.empatkepala.entity.request.AddFpkRequest;
import com.empatkepala.entity.request.ApproveRejectFpkRequest;
import com.empatkepala.entity.response.FpkResponse;
import com.empatkepala.enumeration.Department;
import com.empatkepala.enumeration.Role;
import com.empatkepala.repository.FpkRepository;
import com.empatkepala.service.FpkService;
import com.empatkepala.service.JobVacancyService;
import com.empatkepala.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ALz on 3/11/2017.
 */
@RestController
@RequestMapping(value="/fpk")
@CrossOrigin(origins = "*")
public class FpkController {
    @Autowired
    FpkService fpkService;
    @Autowired
    UserService userService;
    @Autowired
    JobVacancyService jobVacancyService;

    @RequestMapping(value = "/getAllFpk", method = RequestMethod.GET,produces = "application/json")
    public FpkResponse getAllFpk(){
        FpkResponse result = new FpkResponse();
        Collection<Fpk> data = new ArrayList<>();
        data = fpkService.getAllData();
        result.setData(data);
        result.setTotalData(data.size());
        result.setStatus(HttpStatus.OK.toString());
        result.setMessage("Success");
        result.setMethod("GET");
        result.setRequestHeader(AddFpkRequest.getHeaderContentType());
        result.setRequestBody("");
        return result;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = "application/json")
    public FpkResponse getFpk(@PathVariable("id") long id ){
        FpkResponse result = new FpkResponse();
        Collection<Fpk> data = new ArrayList<>();
        data.add(fpkService.getFpk(id));
        result.setData(data);
        result.setTotalData(data.size());
        result.setStatus(HttpStatus.FOUND.toString());
        result.setMessage("Success");
        return result;
    }

    @RequestMapping(method = RequestMethod.POST,produces = "application/json")
    public FpkResponse addFpk(
            @RequestBody AddFpkRequest addFpkRequest)
    {
        fpkService.addFpk(addFpkRequest,false,false);
        return new FpkResponse(HttpStatus.ACCEPTED.toString(),"Success Add Fpk",null,1,
                "POST",AddFpkRequest.getHeaderContentType(),AddFpkRequest.getRequestBody());
    }

    @RequestMapping(value = "/add/byMemberDepartment", method = RequestMethod.POST,produces = "application/json")
    public FpkResponse addFpkByMemberDepartment(
            @RequestBody AddFpkRequest addFpkRequest)
    {
        fpkService.addFpk(addFpkRequest,false, false);
        return new FpkResponse(HttpStatus.ACCEPTED.toString(),"Success Add Fpk",null,1,
                "POST",AddFpkRequest.getHeaderContentType(),AddFpkRequest.getRequestBody());
    }

    @RequestMapping(value = "/add/byHeadDepartment", method = RequestMethod.POST,produces = "application/json")
    public FpkResponse addFpkByHeadDepartment(
            @RequestBody AddFpkRequest addFpkRequest)
    {
        fpkService.addFpk(addFpkRequest,true, true);
        return new FpkResponse(HttpStatus.ACCEPTED.toString(),"Success Add Fpk",null,1,
                "POST",AddFpkRequest.getHeaderContentType(),AddFpkRequest.getRequestBody());
    }

    @RequestMapping(value = "/approve", method = RequestMethod.POST, produces = "application/json")
    public FpkResponse approveFpk(@RequestBody ApproveRejectFpkRequest approveRejectFpkRequest){
        try {
            User userRequested = userService.getUser(approveRejectFpkRequest.getIdUser());
            Fpk fpkToPublish = fpkService.getFpk(approveRejectFpkRequest.getIdFpk());
            fpkService.approveFpk(fpkToPublish, userRequested);
            jobVacancyService.addPersonNeeded(userRequested.getDepartment(),fpkToPublish.getNumberOfPerson(),fpkToPublish.getJobPositionRequester());
            return new FpkResponse("Sukses Approve", "Success Approve Fpk", null);
        }catch(Exception ex){
            return new FpkResponse(ex.toString(),ex.getStackTrace().toString(),null);
        }
    }

    @RequestMapping(value = "/approve/asHeadDepartment", method = RequestMethod.POST, produces = "application/json")
    public FpkResponse approveFpkAsHeadDepartment(@RequestBody ApproveRejectFpkRequest approveRejectFpkRequest){
        try {
            fpkService.approveFpkAsHeadDepartment(
                    fpkService.getFpk(approveRejectFpkRequest.getIdFpk()),
                    userService.getUser(approveRejectFpkRequest.getIdUser()));
            return new FpkResponse("Sukses Approve", "Success Approve Fpk", null);
        }catch(Exception ex){
            return new FpkResponse(ex.toString(),ex.getStackTrace().toString(),null);
        }
    }

    @RequestMapping(value = "/reject", method = RequestMethod.POST, produces = "application/json")
    public FpkResponse rejectFpk(@RequestBody ApproveRejectFpkRequest approveRejectFpkRequest){
        fpkService.rejectFpk(fpkService.getFpk(approveRejectFpkRequest.getIdFpk()),userService.getUser(approveRejectFpkRequest.getIdUser()));
        return new FpkResponse(HttpStatus.ACCEPTED.toString(),"Success Reject Fpk",null);
    }

    @RequestMapping(value = "/reject/asHeadDepartment", method = RequestMethod.POST, produces = "application/json")
    public FpkResponse rejectFpkAsHeadDepartment(@RequestBody ApproveRejectFpkRequest approveRejectFpkRequest){
        fpkService.rejectFpkAsHeadDepartment(fpkService.getFpk(approveRejectFpkRequest.getIdFpk()),userService.getUser(approveRejectFpkRequest.getIdUser()));
        return new FpkResponse(HttpStatus.ACCEPTED.toString(),"Success Reject Fpk",null);
    }

    @RequestMapping(value = "/byDepartment", method = RequestMethod.GET, produces = "application/json")
    public FpkResponse findFpkByDepartment(@RequestHeader Department department){
        Collection<Fpk> data = fpkService.getFpkByDepartment(department);
        return new FpkResponse(HttpStatus.FOUND.toString(),"Success Get Fpk By Department",data,data.size());
    }

    @RequestMapping(value = "/byDepartment/active", method = RequestMethod.GET, produces = "application/json")
    public FpkResponse findFpkByDepartmentActive(@RequestHeader Department department, @RequestHeader Role role){
        Collection<Fpk> data = fpkService.getFpkActiveByDepartment(department, role);
        return new FpkResponse(HttpStatus.FOUND.toString(),"Success Get Fpk By Department",data,data.size());
    }

    @RequestMapping(value = "/byDepartment/history", method = RequestMethod.GET, produces = "application/json")
    public FpkResponse findFpkByDepartmentHistory(@RequestHeader Department department, @RequestHeader Role role){
        Collection<Fpk> data = fpkService.getFpkHistoryByDepartment(department, role);
        return new FpkResponse(HttpStatus.FOUND.toString(),"Success Get Fpk By Department",data,data.size());
    }

    @RequestMapping(value = "/byDepartment/pending", method = RequestMethod.GET, produces = "application/json")
    public FpkResponse findFpkByDepartmentPending(@RequestHeader Department department, @RequestHeader Role role){
        Collection<Fpk> data = fpkService.getFpkPendingByDepartment(department, role);
        return new FpkResponse(HttpStatus.FOUND.toString(),"Success Get Fpk By Department",data,data.size());
    }

    @RequestMapping(value = "/byDepartment/accepted", method = RequestMethod.GET, produces = "application/json")
    public FpkResponse findFpkByDepartmentAccepted(@RequestHeader Department department, @RequestHeader Role role){
        Collection<Fpk> data = fpkService.getFpkAcceptedByDepartment(department, role);
        return new FpkResponse(HttpStatus.FOUND.toString(),"Success Get Fpk By Department",data,data.size());
    }

    @RequestMapping(value = "/byDepartment/rejected", method = RequestMethod.GET, produces = "application/json")
    public FpkResponse findFpkByDepartmentRejected(@RequestHeader Department department, @RequestHeader Role role){
        Collection<Fpk> data = fpkService.getFpkRejectedByDepartment(department, role);
        return new FpkResponse(HttpStatus.FOUND.toString(),"Success Get Fpk By Department",data,data.size());
    }

    @RequestMapping(value = "/byDepartment/published", method = RequestMethod.GET, produces = "application/json")
    public FpkResponse findFpkByDepartmentHistory(@RequestHeader Department department){
        Collection<Fpk> data = fpkService.getFpkPublished(department);
        return new FpkResponse(HttpStatus.FOUND.toString(),"Success Get Fpk By Department",data,data.size());
    }

    @RequestMapping(value = "/requestedBy", method = RequestMethod.GET, produces = "application/json")
    public FpkResponse findFpkByRequestedUser(@RequestHeader long userId){
        fpkService.getFpkByRequestedBy(userService.getUser(userId));
        return new FpkResponse(HttpStatus.FOUND.toString(),"Success Get Fpk By Requested User",null);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST, produces = "application/json")
    public FpkResponse editFpk(
            @RequestBody AddFpkRequest fpkRequested,
            @RequestHeader long idUser,
            @RequestHeader long idFpkOld){
        fpkService.editFpk(fpkRequested,userService.getUser(idUser),fpkService.getFpk(idFpkOld));
        return new FpkResponse(HttpStatus.ACCEPTED.toString(),"Success Update Fpk",null);
    }

    @RequestMapping(value = "/byDepartment/acceptedNotPublished", method = RequestMethod.GET, produces = "application/json")
    public FpkResponse getFpkReadyToPublish(
            @RequestHeader Department department
    ){
        Collection<Fpk> data = fpkService.getFpkReadyToPublish(department);
        return new FpkResponse(HttpStatus.FOUND.toString(),"Success Get Fpk By Department",data,data.size());
    }

    @RequestMapping(value = "/byDepartment/acceptedPublished", method = RequestMethod.GET, produces = "application/json")
    public FpkResponse getFpkPublished(
            @RequestHeader Department department
    ){
        Collection<Fpk> data = fpkService.getFpkPublished(department);
        return new FpkResponse(HttpStatus.FOUND.toString(),"Success Get Fpk By Department",data,data.size());
    }
}
