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


    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
    @RequestMapping(method = RequestMethod.POST)
    public void addCV(
            @RequestBody CVFormRequest cvFormRequest){
        CV cv = new CV();
        cv.setIdCV(ID_GENERATOR.getAndIncrement());
        cv.setAchievement(cv.getAchievement());
        cv.setAttendancePeriod(cv.getAttendancePeriod());
        cv.setBlog(cv.getBlog());
        cv.setCurrentAddress(cv.getCurrentAddress());
        cv.setDescribeAboutYou(cv.getDescribeAboutYou());
        cv.setDrivingLicense(cv.getDrivingLicense());
        cv.setEmailAddress(cv.getEmailAddress());
        cv.setEmergencyCall(cv.getEmergencyCall());
        cv.setEthnicity(cv.getEthnicity());
        cv.setFacebook(cv.getFacebook());
        cv.setFactorEncourageYouOnThatJob(cv.getFactorEncourageYouOnThatJob());
        cv.setFatherBirthday(cv.getMotherBirthday());
        cv.setFatherCurrentJob(cv.getFatherCurrentJob());
        cv.setFatherLatestEducation(cv.getFatherLatestEducation());
        cv.setFatherName(cv.getFatherName());
        cv.setFieldOfOrganization(cv.getFieldOfOrganization());
        cv.setFullName(cv.getFullName());
        cv.setHandphone(cv.getHandphone());
        cv.setHaveAppliedOnGDN(cv.getHaveAppliedOnGDN());
        cv.setIdCardNumber(cv.getIdCardNumber());
        cv.setHavePartTimejob(cv.getHavePartTimejob());
        cv.setHobbies(cv.getHobbies());
        cv.setFactorEncourageYouOnThatJob(cv.getFactorEncourageYouOnThatJob());
        cv.setHomeAddress(cv.getHomeAddress());
        cv.setHomePhone(cv.getHomePhone());
        cv.setKindOfEnvirontment(cv.getKindOfEnvirontment());
        cv.setJobTitle(cv.getJobTitle());
        cv.setLifeValue(cv.getLifeValue());
        cv.setLinkedIn(cv.getLinkedIn());
        cv.setMaritalStatus(cv.getMaritalStatus());
        cv.setMotherBirthday(cv.getMotherBirthday());
        cv.setMotherName(cv.getMotherName());
        cv.setMotherCurretJob(cv.getMotherCurretJob());
        cv.setMotherLatestEducation(cv.getMotherLatestEducation());
        cv.setPlaceDateOfBirth(cv.getPlaceDateOfBirth());
        cv.setPlaceGetInformationGDN(cv.getPlaceGetInformationGDN());
        cv.setNotes(cv.getNotes());
        cv.setNotesAchievement(cv.getNotesAchievement());
        cv.setSpousebirthDay(cv.getSpousebirthDay());
        cv.setSpouseCurrentJob(cv.getSpouseCurrentJob());
        cv.setSpouseLatestEducation(cv.getSpouseLatestEducation());
        cv.setSpouseName(cv.getSpouseName());
        cv.setTimeStartWork(cv.getTimeStartWork());
        cv.setReligion(cv.getReligion());
        cv.setSpesificSkill(cv.getSpesificSkill());
        cv.setYearAchievement(cv.getYearAchievement());
        cv.setBro(cv.getBro());
        cv.setBro(cv.getBro());
        cv.setS(cv.getS());
        cv.setChil(cv.getChil());
        cv.setSchool(cv.getSchool());
        cv.setWorkExp(cv.getWorkExp());
        cv.setResponsibilities(cv.getResponsibilities());
        cv.setResponsibilitiesType(cv.getResponsibilitiesType());



       // cv.setRequestedBy(userService.getUser(cvFormRequest.getIdRequestedBy()));

        cvService.addCV(cv);


    }

}
