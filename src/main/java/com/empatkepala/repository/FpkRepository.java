package com.empatkepala.repository;

import com.empatkepala.entity.Fpk;
import com.empatkepala.entity.User;
import com.empatkepala.enumeration.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by ALz on 3/11/2017.
 */
@Repository
public interface FpkRepository extends JpaRepository<Fpk, Long> {
    Collection<Fpk> findByRequestedBy(User requestedBy);
    Collection<Fpk> findByDepartment(Department department);
    Collection<Fpk> findByDepartmentAndAcceptAndReject(Department department, boolean accepted, boolean rejected);
    Collection<Fpk> findByDepartmentAndApproveCeoAndApproveHead(Department department, boolean approveCeo, boolean approveHead);
}
