package com.empatkepala.repository;

import com.empatkepala.entity.Mpp;
import com.empatkepala.entity.User;
import com.empatkepala.enumeration.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Juan on 3/11/17.
 */
@Repository
public interface MppRepository extends JpaRepository<Mpp, Long>{
    Collection<Mpp> findByRequestedBy(User requestedBy);
    Collection<Mpp> findByDepartment(Department department);
    Collection<Mpp> findByDepartmentAndAcceptAndReject(Department department, boolean accepted, boolean rejected);
    Collection<Mpp> findByRequestedByAndAcceptAndReject(User requestedBy, boolean accepted, boolean rejected);

    Collection<Mpp> findByRejectedByAndDepartmentAndReject(User rejectedBy, Department department, boolean rejected);
    Collection<Mpp> findByApprovedByAndDepartmentAndAccept(User approvedBy, Department department, boolean accepted);

    Collection<Mpp> findByDepartmentAndAcceptAndRejectAndPublished(Department department, boolean accepted, boolean rejected, boolean published);
    Collection<Mpp> findByDepartmentAndPublished(Department department, boolean published);

    Collection<Mpp> findByDepartmentAndAcceptHrdAndRejectHrd(Department department, boolean acceptedHrd, boolean rejectedHrd);
    Collection<Mpp> findByDepartmentAndAcceptedHrdByAndAcceptHrd(Department department, User acceptedHrdBy, boolean acceptedHrd);
    Collection<Mpp> findByDepartmentAndRejectedHrdByAndRejectHrd(Department department, User rejectedHrdBy, boolean rejectedHrd);
    Page<Mpp> findByDepartmentAndAcceptAndRejectAndAcceptHrdAndRejectHrd(Department department, boolean accepted, boolean rejected, boolean acceptedHrd, boolean rejectedHrd, Pageable pageable);

}
