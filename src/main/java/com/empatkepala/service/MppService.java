package com.empatkepala.service;

import com.empatkepala.entity.Mpp;
import com.empatkepala.entity.User;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Juan on 3/11/17.
 */
public interface MppService {
    User getRequestedByByMppId(Long id);

    Mpp getMppById(Long id);

    Collection<Mpp> getAllMpp();

    void addMpp(Mpp mpp);


}
