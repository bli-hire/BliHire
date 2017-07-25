package com.empatkepala.service;

import com.empatkepala.entity.CV;

import java.util.Collection;

/**
 * Created by Ryan Bagus Susilo on 4/21/2017.
 */
public interface CVService  {
    CV getRequestedByCVId(Long id);

    CV getCVById(Long id);

    Collection<CV> getAllCV();

    void addCV(CV cv);
}
