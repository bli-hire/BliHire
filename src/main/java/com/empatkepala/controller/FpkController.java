package com.empatkepala.controller;

import com.empatkepala.entity.Fpk;
import com.empatkepala.entity.request.AddFpkRequest;
import com.empatkepala.enumeration.Department;
import com.empatkepala.repository.FpkRepository;
import com.empatkepala.service.FpkService;
import com.empatkepala.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * Created by ALz on 3/11/2017.
 */
@RestController(value="/internal/fpk")
public class FpkController {
    @Autowired
    FpkService fpkService;
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET,produces = "application/json")
    public List getAllFpk(){
        List<Fpk> result = fpkService.getAllData();
        return result;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = "application/json")
    public Fpk getFpk(@PathVariable("id") Long id ){
        return fpkService.getFpk(id);
    }

    @RequestMapping(method = RequestMethod.POST,produces = "application/json")
    public void addFpk(
            @RequestBody AddFpkRequest addFpkRequest)
    {

        fpkService.addFpk(addFpkRequest);
    }

    @RequestMapping(value = "/approve", method = RequestMethod.POST, produces = "application/json")
    public boolean approveFpk(@RequestBody long idApprover, long fpkId){
                return fpkService.approveFpk(fpkService.getFpk(fpkId),userService.getUser(idApprover));
    }

    @RequestMapping(value = "/reject", method = RequestMethod.POST, produces = "application/json")
    public boolean rejectFpk(@RequestBody long idRejecter, long fpkId){
        return fpkService.rejectFpk(fpkService.getFpk(fpkId),userService.getUser(idRejecter));
    }

    @RequestMapping(value = "/byDepartment", method = RequestMethod.GET, produces = "application/json")
    public Collection<Fpk> findFpkByDepartment(@RequestHeader Department department){
        return fpkService.getFpkByDepartment(department);
    }

    @RequestMapping(value = "/requestedBy", method = RequestMethod.GET, produces = "application/json")
    public Collection<Fpk> findFpkByDepartment(@RequestHeader long userId){
        return fpkService.getFpkByRequestedUser(userService.getUser(userId));
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST, produces = "application/json")
    public boolean editFpk(@RequestHeader AddFpkRequest fpkRequested, long idUser, long idFpkOld){
        return fpkService.editFpk(fpkRequested,userService.getUser(idUser),fpkService.getFpk(idFpkOld));
    }
}
