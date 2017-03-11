package com.empatkepala.service.impl;

import com.empatkepala.entity.Mpp;
import com.empatkepala.entity.User;
import com.empatkepala.repository.MppRepository;
import com.empatkepala.service.MppService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Juan on 3/11/17.
 */
@Service
public class MppServiceImpl implements MppService{
    @Autowired
    MppRepository mppRepository;

//    public User getUserByRequestedBy(User user){
//
//        Mpp mpp = mppRepository.findOne(1L);
//        Hibernate.initialize(mpp.getRequestedBy());
//        return mpp.getRequestedBy();
//    }

    @Override
    public User getRequestedByByMppId(Long id){

        Mpp mpp = mppRepository.findOne(id);
//        Hibernate.initialize(mpp.getRequestedBy());
        return mpp.getRequestedBy();
    }

    @Override
    public Mpp getMppById(Long id){
        return mppRepository.findOne(id);
    }

    @Override
    public Collection<Mpp> getAllMpp(){
        return mppRepository.findAll();
    }

    @Override
    public void addMpp(Mpp mpp){
        mppRepository.save(mpp);
    }


}
