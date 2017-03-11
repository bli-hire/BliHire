package com.empatkepala.controller;

import com.empatkepala.entity.Fpk;
import com.empatkepala.repository.FpkRepository;
import com.empatkepala.service.FpkService;
import com.empatkepala.service.impl.FpkServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ALz on 3/11/2017.
 */
@RestController(value="/fpk")
public class FpkController {
    @Autowired
    FpkService fpkService;

    FpkRepository fpkTemp;

    @RequestMapping(method = RequestMethod.GET)
    public List getAllFpk(){
        return fpkService.getAllData();
    }

    @PostMapping
    public void insertFpk(Fpk input){
        fpkService.save(input);
    }

    @PutMapping
    public void updateFpk(Fpk findOne){
        fpkService.update(findOne);
    }
}
