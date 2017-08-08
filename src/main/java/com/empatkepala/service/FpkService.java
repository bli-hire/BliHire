package com.empatkepala.service;

import com.empatkepala.entity.Fpk;
import com.empatkepala.entity.User;
import com.empatkepala.entity.request.AddFpkRequest;
import com.empatkepala.enumeration.Department;
import com.empatkepala.enumeration.Role;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.List;

/**
 * Created by ALz on 3/11/2017.
 */
@Service
public interface FpkService{

    Collection<Fpk> getFpkByDepartment(Department department);

    Collection<Fpk> getFpkByRequestedBy(User requestedBy);

    Collection<Fpk> getFpkHistoryByDepartment(Department department, Role role);

    Collection<Fpk> getFpkActiveByDepartment(Department department, Role role);

    Collection<Fpk> getFpkAcceptedByDepartment(Department department, Role role);

    Collection<Fpk> getFpkRejectedByDepartment(Department department, Role role);

    Collection<Fpk> getFpkPendingByDepartment(Department department, Role role);

    Collection<Fpk> getFpkPublished(Department department);

    Collection<Fpk> getFpkReadyToPublish(Department department);

    List getAllData();

    Fpk getFpk(long id);

    void addFpk(@RequestBody AddFpkRequest addFpkRequest, boolean headApprove, boolean isHeadRejectOrApprove);

    boolean editFpk(AddFpkRequest fpkRequest, User editor, Fpk fpkToEdit);

    boolean approveFpk(Fpk fpk, User approver);

    boolean approveFpkAsHeadDepartment(Fpk fpk, User approver);

    boolean rejectFpkAsHeadDepartment(Fpk fpk, User approver);

    boolean rejectFpk(Fpk fpk, User rejecter);
}
