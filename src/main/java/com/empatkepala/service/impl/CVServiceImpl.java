package com.empatkepala.service.impl;

import com.empatkepala.entity.CV;
import com.empatkepala.repository.CVRepository;
import com.empatkepala.service.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

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
//        Hibernate.initialize(mpp.getRequestedBy());
        return cv.getRequestedBy();
    }


    public CV getCVById(Long id){
        return cvRepository.findOne(id);
    }

    public Collection<CV> getAllCV(){
        return cvRepository.findAll();
    }

    public void addCV(CV cv){
        cvRepository.save(cv);
    }


}
