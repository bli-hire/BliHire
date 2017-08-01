package com.empatkepala.service.impl;

import com.empatkepala.entity.CV;
import com.empatkepala.entity.request.CVFormRequest;
import com.empatkepala.repository.CVRepository;
import com.empatkepala.service.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Ryan Bagus Susilo on 4/21/2017.
 */
@Service
public class CVServiceImpl implements CVService{
    @Autowired
    CVRepository cvRepository;

    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);


//    public User getUserByRequestedBy(User user){
//
//        Mpp mpp = mppRepository.findOne(1L);
//        Hibernate.initialize(mpp.getRequestedBy());
//        return mpp.getRequestedBy();
//    }


    public CV getRequestedByCVId(Long id){

        CV cv = cvRepository.findOne(id);
//        Hibernate.initialize(mpp.getRequestedBy());
        return cv.getRequestedBy();
    }


    public CV getCVById(Long id){
        return cvRepository.findOne(id);
    }

    public Collection<CV> getAllCV(){
        return cvRepository.findAll();
    }

    public void addCV(
            @RequestBody CVFormRequest cvFormRequest)
    {

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

        cvRepository.save(cv);
    }


}
