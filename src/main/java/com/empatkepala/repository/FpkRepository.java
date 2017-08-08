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
    Collection<Fpk> findByDepartmentAndAcceptAndStatusAccept(Department department, boolean accepted, boolean statusAccept);
    Collection<Fpk> findByDepartmentAndApproveCeoAndStatusCeoApprove(Department department, boolean approveCeo, boolean statusApprove);
    Collection<Fpk> findByDepartmentAndApproveHeadAndStatusHeadApprove(Department department, boolean approveCeo, boolean statusApprove);
    Collection<Fpk> findByDepartmentAndAcceptAndApproveCeoAndStatusCeoApprove(Department department, boolean accept, boolean approveCeo, boolean statusApproveCeo);
}
