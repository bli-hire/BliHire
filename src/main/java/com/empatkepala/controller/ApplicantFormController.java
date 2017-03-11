package com.empatkepala.controller;

import com.empatkepala.entity.ApplicantDate;
import com.empatkepala.entity.ApplicantForm;
import com.empatkepala.entity.ApplicantScore;
import com.empatkepala.entity.request.AddApplicationRequest;
import com.empatkepala.entity.request.ApplicationDateRequest;
import com.empatkepala.entity.request.ApplicationScoreRequest;
import com.empatkepala.service.ApplicantFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApplicantFormController {

    @Autowired
    ApplicantFormService applicantFormService;

    @RequestMapping(method = RequestMethod.GET, value = "/external/tracking/{id}", produces = "application/json")
    public ApplicantForm trackApplicationById(
            @PathVariable Long id
    ){
        return applicantFormService.trackApplicationById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/external/register")
    public void addApplication(
            @RequestBody AddApplicationRequest addApplicationRequest
            ){
        ApplicantForm applicantForm = new ApplicantForm();
        ApplicantDate applicantDate = new ApplicantDate();
        ApplicantScore applicantScore = new ApplicantScore();

        ApplicationDateRequest applicationDateRequest = addApplicationRequest.getApplicationDateRequest();
        ApplicationScoreRequest applicationScoreRequest = addApplicationRequest.getApplicationScoreRequest();

        applicantDate.setAfterMCU(applicationDateRequest.getAfterMCU());
        applicantDate.setCallDate(applicationDateRequest.getCallDate());
        applicantDate.setFirstInterviewUserDate(applicationDateRequest.getFirstInterviewUserDate());
        applicantDate.setSecondInterviewUserDate(applicationDateRequest.getSecondInterviewUserDate());
        applicantDate.setThirdInterviewUserDate(applicationDateRequest.getThirdInterviewUserDate());
        applicantDate.setInterviewHRDate(applicationDateRequest.getInterviewHRDate());
        applicantDate.setJoinDate(applicationDateRequest.getJoinDate());
        applicantDate.setMCU(applicationDateRequest.getMCU());
        applicantDate.setNoticeLetter(applicationDateRequest.getNoticeLetter());
        applicantDate.setPsychoTestDate(applicationDateRequest.getPsychoTestDate());
        applicantDate.setTechnicalTestDate(applicationDateRequest.getTechnicalTestDate());


        applicantScore.setFirstInterviewTestScore(applicationScoreRequest.getFirstInterviewTestScore());
        applicantScore.setHRTestScore(applicationScoreRequest.getHRTestScore());
        applicantScore.setMCUScore(applicationScoreRequest.getMCUScore());
        applicantScore.setPsychoTestScore(applicationScoreRequest.getPsychoTestScore());
        applicantScore.setSecondInterviewTestScore(applicationScoreRequest.getSecondInterviewTestScore());
        applicantScore.setThirdInterviewTestScore(applicationScoreRequest.getThirdInterviewTestScore());
        applicantScore.setTechnicalTestScore(applicationScoreRequest.getTechnicalTestScore());

        applicantForm.setApplicantDate(applicantDate);
        applicantForm.setApplicantScore(applicantScore);

        applicantFormService.saveApplication(applicantForm);
    }
}
