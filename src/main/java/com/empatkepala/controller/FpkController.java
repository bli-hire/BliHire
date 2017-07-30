package com.empatkepala.controller;

import com.empatkepala.entity.Fpk;
import com.empatkepala.entity.request.AddFpkRequest;
import com.empatkepala.service.FpkService;
import com.empatkepala.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return fpkService.getAllData();
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

    @RequestMapping(method = RequestMethod.PUT,produces = "application/json")
    public void updateFpk(Fpk findOne){
        fpkService.update(findOne);
    }

    @RequestMapping(method = RequestMethod.DELETE,produces = "application/json")
    public void deleteFpk(@RequestBody AddFpkRequest addFpkRequest){
        fpkService.delete(addFpkRequest.getId());
    }
}
