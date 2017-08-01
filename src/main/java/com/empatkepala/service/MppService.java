package com.empatkepala.service;

import com.empatkepala.entity.Mpp;
import com.empatkepala.entity.User;
import com.empatkepala.entity.request.AddMppRequest;
import com.empatkepala.entity.request.MppFormRequest;
import com.empatkepala.enumeration.Department;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

/**
 * Created by Juan on 3/11/17.
 */
public interface MppService {
    User getRequestedByByMppId(Long id);

    Mpp getMppById(Long id);

    Collection<Mpp> getAllMpp();

    void addMpp(Mpp mpp);

    boolean approveMpp(Mpp mpp, User approver);

    boolean rejectMpp(Mpp mpp, User rejector);

    Collection<Mpp> getMppByDepartment(Department department);

    Collection<Mpp> getMppByRequestedBy(User requestedBy);

    boolean editMpp(MppFormRequest mppFormRequest, User editor, Mpp mppToEdit);
    void addMpp(@RequestBody AddMppRequest addMppRequest);

}
