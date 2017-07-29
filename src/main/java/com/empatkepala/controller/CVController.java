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

    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
    @RequestMapping(value ="/add" , method = RequestMethod.POST)
    public void addCV(
            @RequestBody CVFormRequest cvFormRequest){
        CV cv = new CV();
        cv.setIdCV(ID_GENERATOR.getAndIncrement());
        cv.setTitle(cvFormRequest.getTitle());
        cv.setBlog(cvFormRequest.getBlog());
        cv.setCurrentAddress(cvFormRequest.getCurrentAddress());
        cv.setDescribeAboutYou(cvFormRequest.getDescribeAboutYou());
        cv.setDrivingLicense(cvFormRequest.getDrivingLicense());
        cv.setEmailAddress(cvFormRequest.getEmailAddress());
        cv.setEmergencyCall(cvFormRequest.getEmergencyCall());
        cv.setEthnicity(cvFormRequest.getEthnicity());
        cv.setFacebook(cvFormRequest.getFacebook());
        cv.setFactorEncourageYouOnThatJob(cvFormRequest.getFactorEncourageYouOnThatJob());
        cv.setFatherBirthday(cvFormRequest.getMotherBirthday());
        cv.setFatherCurrentJob(cvFormRequest.getFatherCurrentJob());
        cv.setFatherLatestEducation(cvFormRequest.getFatherLatestEducation());
        cv.setFatherName(cvFormRequest.getFatherName());
        cv.setFullName(cvFormRequest.getFullName());
        cv.setHandphone(cvFormRequest.getHandphone());
        cv.setHaveAppliedOnGDN(cvFormRequest.getHaveAppliedOnGDN());
        cv.setIdCardNumber(cvFormRequest.getIdCardNumber());
        cv.setHavePartTimejob(cvFormRequest.getHavePartTimejob());
        cv.setHobbies(cvFormRequest.getHobbies());
        cv.setFactorEncourageYouOnThatJob(cvFormRequest.getFactorEncourageYouOnThatJob());
        cv.setHomeAddress(cvFormRequest.getHomeAddress());
        cv.setHomePhone(cvFormRequest.getHomePhone());
        cv.setKindOfEnvirontment(cvFormRequest.getKindOfEnvirontment());
        cv.setJobTitle(cvFormRequest.getJobTitle());
        cv.setReasonMajor(cvFormRequest.getReasonMajor());
        cv.setTitleThesis(cvFormRequest.getTitleThesis());
        cv.setRelativeWorkingOnGDN(cvFormRequest.getRelativeWorkingOnGDN());
        cv.setTwitter(cvFormRequest.getTwitter());
        cv.setLifeValue(cvFormRequest.getLifeValue());
        cv.setLinkedIn(cvFormRequest.getLinkedIn());
        cv.setMaritalStatus(cvFormRequest.getMaritalStatus());
        cv.setMotherBirthday(cvFormRequest.getMotherBirthday());
        cv.setMotherName(cvFormRequest.getMotherName());
        cv.setmotherCurrentJob(cvFormRequest.getmotherCurrentJob());
        cv.setMotherLatestEducation(cvFormRequest.getMotherLatestEducation());
        cv.setPlaceDateOfBirth(cvFormRequest.getPlaceDateOfBirth());
        cv.setPlaceGetInformationGDN(cvFormRequest.getPlaceGetInformationGDN());
        cv.setSpousebirthDay(cvFormRequest.getSpousebirthDay());
        cv.setSpouseCurrentJob(cvFormRequest.getSpouseCurrentJob());
        cv.setSpouseLatestEducation(cvFormRequest.getSpouseLatestEducation());
        cv.setSpouseName(cvFormRequest.getSpouseName());
        cv.setTimeStartWork(cvFormRequest.getTimeStartWork());
        cv.setReligion(cvFormRequest.getReligion());
        cv.setSpesificSkill(cvFormRequest.getSpesificSkill());
        cv.setReasonInterestedInGDN(cvFormRequest.getReasonInterestedInGDN());
        cv.setReasonApplyOnThatPosition(cvFormRequest.getReasonApplyOnThatPosition());
        cv.setBro(cvFormRequest.getBro());
        cv.setNonFrmlCrs(cvFormRequest.getNonFrmlCrs());
        cv.setChil(cvFormRequest.getChil());
        cv.setSchool(cvFormRequest.getSchool());
        cv.setWorkExp(cvFormRequest.getWorkExp());
        cv.setResponsibilities(cvFormRequest.getResponsibilities());
        cv.setResponsibilitiesType(cvFormRequest.getResponsibilitiesType());
        cv.setSocialact(cvFormRequest.getSocialact());
        cv.setAchievements(cvFormRequest.getAchievements());
        cv.setLanguage(cvFormRequest.getLanguage());

       // cv.setRequestedBy(userService.getUser(cvFormRequest.getIdRequestedBy()));
        cvService.addCV(cv);
    }

}
