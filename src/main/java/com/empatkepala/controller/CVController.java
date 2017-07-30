package com.empatkepala.controller;

import com.empatkepala.entity.CV;
import com.empatkepala.entity.Mpp;
import com.empatkepala.entity.request.CVFormRequest;
import com.empatkepala.entity.request.MppFormRequest;
import com.empatkepala.service.CVService;
import com.empatkepala.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Ryan Bagus Susilo on 4/21/2017.
 */
@RestController
@RequestMapping(value = "/cv")
@CrossOrigin("*")
public class CVController {
    @Autowired
    private CVService cvService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET,produces = "application/json")
    public Collection<CV> getAllCV(){
        return cvService.getAllCV();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addUser(@RequestBody CVFormRequest addCVFormRequest)
    {
        cvService.addCV(addCVFormRequest);
    }

}
