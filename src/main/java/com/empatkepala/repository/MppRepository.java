package com.empatkepala.repository;

import com.empatkepala.entity.Mpp;
import com.empatkepala.entity.User;
import com.empatkepala.enumeration.Department;
import com.empatkepala.enumeration.MppStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Created by Juan on 3/11/17.
 */
@Repository
public interface MppRepository extends JpaRepository<Mpp, Long>{
    Page<Mpp> findByRequestedBy(User requestedBy, Pageable pageable);
    Collection<Mpp> findByDepartment(Department department);
    Collection<Mpp> findByDepartmentAndAcceptAndReject(Department department, boolean accepted, boolean rejected);
    Collection<Mpp> findByRequestedByAndAcceptAndReject(User requestedBy, boolean accepted, boolean rejected);

    Page<Mpp> findByRejectedByAndDepartmentAndReject(User rejectedBy, Department department, boolean rejected, Pageable pageable);
    Page<Mpp> findByApprovedByAndDepartmentAndAccept(User approvedBy, Department department, boolean accepted, Pageable pageable);

    Collection<Mpp> findByDepartmentAndAcceptAndRejectAndPublished(Department department, boolean accepted, boolean rejected, boolean published);
    Collection<Mpp> findByDepartmentAndPublished(Department department, boolean published);

    Collection<Mpp> findByDepartmentAndAcceptHrdAndRejectHrd(Department department, boolean acceptedHrd, boolean rejectedHrd);
    Page<Mpp> findByDepartmentAndAcceptedHrdByAndAcceptHrd(Department department, User acceptedHrdBy, boolean acceptedHrd, Pageable pageable);
    Page<Mpp> findByDepartmentAndRejectedHrdByAndRejectHrd(Department department, User rejectedHrdBy, boolean rejectedHrd, Pageable pageable);
    Page<Mpp> findByDepartmentAndAcceptAndRejectAndAcceptHrdAndRejectHrd(Department department, boolean accepted, boolean rejected, boolean acceptedHrd, boolean rejectedHrd, Pageable pageable);

    Page<Mpp> findByMppStatusAndDepartment(MppStatus mppStatus, Department department, Pageable pageable);
    Page<Mpp> findByMppStatusAndDepartmentAndApprovedBy(MppStatus mppStatus, Department department, Pageable pageable, User approvedBy);
    Page<Mpp> findByMppStatusAndDepartmentAndRejectedBy(MppStatus mppStatus, Department department, Pageable pageable, User rejectedBy);
    Page<Mpp> findByMppStatusAndDepartmentAndRejectedHrdBy(MppStatus mppStatus, Department department, Pageable pageable, User rejectedHrdBy);
    Page<Mpp> findByMppStatusAndDepartmentAndAcceptedHrdBy(MppStatus mppStatus, Department department, Pageable pageable, User acceptedHrdBy);
    Page<Mpp> findByMppStatusAndRequestedBy(MppStatus mppStatus, Pageable pageable, User requestedBy);

    Page<Mpp> findByMppStatusInAndRequestedBy(List<MppStatus> listMppStatus, User requestedBy, Pageable pageable);

//    Page<Mpp> findByRequestedBy(User requestedBy);

}
