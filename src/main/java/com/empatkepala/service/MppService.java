package com.empatkepala.service;

import com.empatkepala.entity.Mpp;
import com.empatkepala.entity.User;
import com.empatkepala.entity.request.AddMppRequest;
import com.empatkepala.enumeration.Department;
import com.empatkepala.enumeration.MppStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    boolean resendMpp(Mpp mpp, User resender);

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
    Collection<Mpp> getMppByRequestedByAccepted(User requestedBy);
    Collection<Mpp> getMppByRequestedByRejected(User requestedBy);

    //get accept reject by rejector / acceptor CEO by department
    Page<Mpp> getRejectedMppByRejectorAndDepartment(User rejector, Department department, Pageable pageable);
    Page<Mpp> getAcceptedMppByAcceptorAndDepartment(User acceptor, Department department, Pageable pageable);

    //get accept reject by rejector / acceptor HRD by department
    Page<Mpp> getRejectedMppByHrdRejectorAndDepartment(User rejectorHrd, Department department, Pageable pageable);
    Page<Mpp> getAcceptedMppByHrdAcceptorAndDepartment(User acceptorHrd, Department department, Pageable pageable);


    Page<Mpp> getMppToProccessedByHrdByDepartment(Department department, Pageable pageable);
    Page<Mpp> getMppToProccessedByCEOByDepartment(Department department, Pageable pageable);

    //for hrd and ceo to process
    Page<Mpp> getMppByMppStatusAndDepartment(Department department, Pageable pageable, MppStatus mppStatus);

    //for history
    Page<Mpp> getMppByMppStatusAndDepartmentAndProcessedBy(Department department, Pageable pageable, MppStatus mppStatus, User processor);

    Page<Mpp> getMppByRequestedByPendingStatus(User requestedBy, Pageable pageable);
    Page<Mpp> getMppByRequestedByAcceptedStatus(User requestedBy, Pageable pageable);
    Page<Mpp> getMppByRequestedByRejectedStatus(User requestedBy, Pageable pageable);



    Collection<Mpp> getPublishedMppByDepartment(Department department);
//    boolean editMpp(MppFormRequest mppFormRequest, User editor, Mpp mppToEdit);
    void addMpp(@RequestBody AddMppRequest addMppRequest);

    boolean publishMpp(Mpp mpp, User whoPublish);

}
