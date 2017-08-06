package com.empatkepala.controller;

import com.empatkepala.entity.CV;
import com.empatkepala.entity.Fpk;
import com.empatkepala.entity.Mpp;
import com.empatkepala.entity.request.CVFormRequest;
import com.empatkepala.entity.request.MppFormRequest;
import com.empatkepala.entity.response.CVResponse;
import com.empatkepala.service.CVService;
import com.empatkepala.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
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


    @RequestMapping(method = RequestMethod.GET,produces = "application/json")
    public CVResponse getAllCV() {
        CVResponse result = new CVResponse();
        Collection<CV> data =new ArrayList<>();
        data = cvService.getAllCV();
        result.setData(data);
        result.setTotalData(data.size());
        result.setStatus(HttpStatus.FOUND.toString());
        result.setMethod(HttpMethod.GET.name());
        result.setMessage("Success");
        return result;
    }

    @RequestMapping(value = "/updateStatusApplicant", method = RequestMethod.POST)
    public CVResponse updateStatusApplicant(
            @RequestHeader String uid,
            @RequestBody CVFormRequest cvFormRequest ){
        try {
            cvService.updateStatusApplicant(cvFormRequest,uid);
            return new CVResponse(HttpStatus.ACCEPTED.toString(),"Success Update Status Applicant",null,0);
        }catch(Exception ex){
            return new CVResponse(HttpStatus.NOT_ACCEPTABLE.toString(),ex.getMessage(),null,0);
        }

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addCV(@RequestBody CVFormRequest addCVFormRequest)
    {
        cvService.addCV(addCVFormRequest);
    }

    @RequestMapping(value = "/getCVByUid", method = RequestMethod.GET)
    public CVResponse getCVByUid(
            @RequestHeader String uid){
        try {
            List<CV> resultCv = new ArrayList<>();
            resultCv.add(cvService.findByUid(uid));
            return new CVResponse(HttpStatus.ACCEPTED.toString(),"Success Get Data ",resultCv, resultCv.size());
        }catch(Exception ex){
            return new CVResponse(HttpStatus.NOT_ACCEPTABLE.toString(),ex.getMessage(),null,0);
        }

    }

}
