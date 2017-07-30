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




//    public User getUserByRequestedBy(User user){
//
//        Mpp mpp = mppRepository.findOne(1L);
//        Hibernate.initialize(mpp.getRequestedBy());
//        return mpp.getRequestedBy();
//    }



    public CV getRequestedByCVId(Long id){
        CV cv = cvRepository.findOne(id);
        return cv.getRequestedBy();
    }

    public CV getCVById(Long id){
        return cvRepository.findOne(id);
    }

    public Collection<CV> getAllCV(){
        return cvRepository.findAll();
    }

    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);
    public void addCV(
            @RequestBody CVFormRequest cvFormRequest)
    {

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

        cvRepository.save(cv);
    }



}
