package com.empatkepala.service;

import com.empatkepala.entity.Fpk;
import com.empatkepala.entity.User;
import com.empatkepala.entity.request.AddFpkRequest;
import com.empatkepala.enumeration.Department;
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

    Collection<Fpk> getFpkHistoryByDepartment(Department department);

    Collection<Fpk> getFpkActiveByDepartment(Department department);

    Collection<Fpk> getFpkAcceptedByDepartment(Department department);

    Collection<Fpk> getFpkRejectedByDepartment(Department department);

    Collection<Fpk> getFpkPendingByDepartment(Department department);

    List getAllData();

    Fpk getFpk(long id);

    void addFpk(@RequestBody AddFpkRequest addFpkRequest, boolean headApprove);

    boolean editFpk(AddFpkRequest fpkRequest, User editor, Fpk fpkToEdit);

    boolean approveFpk(Fpk fpk, User approver);

    boolean rejectFpk(Fpk fpk, User rejecter);
}
