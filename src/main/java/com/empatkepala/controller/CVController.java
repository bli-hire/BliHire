package com.empatkepala.controller;

import com.empatkepala.entity.CV;
import com.empatkepala.entity.Mpp;
import com.empatkepala.entity.request.CVFormRequest;
import com.empatkepala.entity.request.MppFormRequest;
import com.empatkepala.service.CVService;
import com.empatkepala.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Ryan Bagus Susilo on 4/21/2017.
 */
@RestController
@RequestMapping(value = "/cv")
public class CVController {
    @Autowired
    private CVService cvService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST)
    public void addCV(
            @RequestBody CVFormRequest cvFormRequest)
    {
       // cv.setRequestedBy(userService.getUser(cvFormRequest.getIdRequestedBy()));
        cvService.addCV(cvFormRequest);
    }

}
