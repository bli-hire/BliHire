package com.empatkepala.service;

import com.empatkepala.entity.Fpk;
import com.empatkepala.repository.FpkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * Created by ALz on 3/11/2017.
 */
@Service
public class FpkService {
    @Autowired
    FpkRepository fpkRepository;

    public List getAllData(){
        return fpkRepository.findAll();
    }

    public void save(Fpk data){
        fpkRepository.save(data);
    }

    public void update(Fpk data){
        fpkRepository.save(data);
    }
}
