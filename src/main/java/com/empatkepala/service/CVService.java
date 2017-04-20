package com.empatkepala.service;

import com.empatkepala.entity.CV;
import com.empatkepala.entity.User;

import java.util.Collection;

/**
 * Created by Ryan Bagus Susilo on 4/21/2017.
 */
public interface CVService  {
    User getRequestedByCVCId(Long id);

    CV getMppById(Long id);

    Collection<CV> getAllCV();

    void addMpp(CV cv);
}
