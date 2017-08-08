package com.empatkepala.service;

import com.empatkepala.entity.CV;
import com.empatkepala.entity.request.CVFormRequest;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Collection;

/**
 * Created by Ryan Bagus Susilo on 4/21/2017.
 */
public interface CVService  {

    CV getCVById(Long id);

    CV findByUid(String uid);

    Collection<CV> getAllCV();

    CV addCV(@RequestBody CVFormRequest cvFormRequest);

    void updateStatusApplicant(CVFormRequest cvFormRequest, String uid);

    CV getCVByUid(String uid);

//    CV getLastAddedCv();

}
