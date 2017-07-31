package com.empatkepala.controller;

import com.empatkepala.entity.Fpk;
import com.empatkepala.entity.request.AddFpkRequest;
import com.empatkepala.entity.response.FpkResponse;
import com.empatkepala.enumeration.Department;
import com.empatkepala.repository.FpkRepository;
import com.empatkepala.service.FpkService;
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

    @RequestMapping(method = RequestMethod.GET,produces = "application/json")
    public FpkResponse getAllFpk(){
        FpkResponse result = new FpkResponse();
        Collection<Fpk> data = new ArrayList<>();
        data = fpkService.getAllData();
        result.setData(data);
        result.setTotalData(data.size());
        result.setStatus(HttpStatus.FOUND.toString());
        result.setMessage("Success");
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
        fpkService.addFpk(addFpkRequest);
        return new FpkResponse(HttpStatus.ACCEPTED.toString(),"Success Add Fpk",null);
    }

    @RequestMapping(value = "/approve", method = RequestMethod.POST, produces = "application/json")
    public FpkResponse approveFpk(@RequestBody long idApprover, long fpkId){
        fpkService.approveFpk(fpkService.getFpk(fpkId),userService.getUser(idApprover));
        return new FpkResponse(HttpStatus.ACCEPTED.toString(),"Success Approve Fpk",null);
    }

    @RequestMapping(value = "/reject", method = RequestMethod.POST, produces = "application/json")
    public FpkResponse rejectFpk(@RequestBody long idRejecter, long fpkId){
        fpkService.rejectFpk(fpkService.getFpk(fpkId),userService.getUser(idRejecter));
        return new FpkResponse(HttpStatus.ACCEPTED.toString(),"Success Reject Fpk",null);
    }

    @RequestMapping(value = "/byDepartment", method = RequestMethod.GET, produces = "application/json")
    public FpkResponse findFpkByDepartment(@RequestHeader Department department){
        Collection<Fpk> data = fpkService.getFpkByDepartment(department);
        return new FpkResponse(HttpStatus.FOUND.toString(),"Success Get Fpk By Department",data);
    }

    @RequestMapping(value = "/requestedBy", method = RequestMethod.GET, produces = "application/json")
    public FpkResponse findFpkByRequestedUser(@RequestHeader long userId){
        fpkService.getFpkByRequestedBy(userService.getUser(userId));
        return new FpkResponse(HttpStatus.FOUND.toString(),"Success Get Fpk By Requested User",null);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST, produces = "application/json")
    public FpkResponse editFpk(@RequestHeader AddFpkRequest fpkRequested, long idUser, long idFpkOld){
        fpkService.editFpk(fpkRequested,userService.getUser(idUser),fpkService.getFpk(idFpkOld));
        return new FpkResponse(HttpStatus.ACCEPTED.toString(),"Success Update Fpk",null);
    }
}
