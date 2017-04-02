package com.empatkepala.service.impl;

import com.empatkepala.entity.Fpk;
import com.empatkepala.entity.User;
import com.empatkepala.repository.FpkRepository;
import com.empatkepala.repository.UserRepository;
import com.empatkepala.service.FpkService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * Created by ALz on 3/11/2017.
 */

@Service
public class FpkServiceImpl implements FpkService{
    @Autowired
    FpkRepository fpkRepository;

    public List getAllData(){
        return fpkRepository.findAll();
    }

    @Override
    public Fpk getFpk(Long id) {return fpkRepository.findOne(id);}

    public void save(Fpk data){
        fpkRepository.save(data);
    }

    public void update(Fpk data){
        fpkRepository.save(data);
    }

    @Override
    public void delete(Long id) {fpkRepository.delete(id);}

    public User getRequestUserByFpk(Long id) {
        Fpk fpk = fpkRepository.findOne(id);
//        Hibernate.initialize(user);
        return fpk.getRequestedBy();
    }

    public User getApprovedUserByFpk(Long id) {
        Fpk fpk = fpkRepository.findOne(id);
//        Hibernate.initialize(user);
        return fpk.getRequestedBy();
    }
}
