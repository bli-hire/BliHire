package com.empatkepala.service;

import com.empatkepala.entity.Mpp;
import com.empatkepala.entity.User;
import com.empatkepala.entity.request.AddMppRequest;
import com.empatkepala.enumeration.Department;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

/**
 * Created by Juan on 3/11/17.
 */
public interface MppService {
    User getRequestedByByMppId(Long id);

    Mpp getMppById(Long id);

    Collection<Mpp> getAllMpp();

//    void addMpp(@RequestBody MppFormRequest mppFormRequest);

    boolean approveMpp(Mpp mpp, User approver);

    boolean rejectMpp(Mpp mpp, User rejector);

    boolean approveHrdMpp(Mpp mpp, User approver);

    boolean rejectHrdMpp(Mpp mpp, User rejector);

    Collection<Mpp> getMppByDepartment(Department department);
    Collection<Mpp> getMppHistoryByDepartment(Department department);
    Collection<Mpp> getMppActiveByDepartment(Department department);
    Collection<Mpp> getMppAcceptedByDepartment(Department department);
    Collection<Mpp> getMppAcceptedByDepartmentNotPublished(Department department);

    Collection<Mpp> getMppByRequestedBy(User requestedBy);
    Collection<Mpp> getMppByRequestedByPending(User requestedBy);
    public Collection<Mpp> getMppByRequestedByAccepted(User requestedBy);
    Collection<Mpp> getMppByRequestedByRejected(User requestedBy);

    Collection<Mpp> getRejectedMppByRejectorAndDepartment(User rejector, Department department);
    Collection<Mpp> getAcceptedMppByAcceptorAndDepartment(User acceptor, Department department);


    Collection<Mpp> getPublishedMppByDepartment(Department department);
//    boolean editMpp(MppFormRequest mppFormRequest, User editor, Mpp mppToEdit);
    void addMpp(@RequestBody AddMppRequest addMppRequest);

    boolean publishMpp(Mpp mpp, User whoPublish);

}
