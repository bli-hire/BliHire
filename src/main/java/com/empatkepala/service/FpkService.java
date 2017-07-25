package com.empatkepala.service;

import com.empatkepala.entity.Fpk;
import com.empatkepala.entity.User;
import com.empatkepala.entity.request.AddFpkRequest;
import com.empatkepala.enumeration.Department;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Created by ALz on 3/11/2017.
 */
@Service
public interface FpkService{
    Collection<Fpk> getFpkByDepartment(Department department);

    Collection<Fpk> getFpkByRequestedUser(User userRequested);

    List getAllData();

    Fpk getFpk(Long id);

    void save(Fpk data);

    User getRequestUserByFpk(Long id);

    User getApprovedUserByFpk(Long id);

    User getRequestedUserByFpkId(Long id);

    boolean editFpk(AddFpkRequest fpkRequest, User editor, Fpk fpkToEdit);

    boolean approveFpk(Fpk fpk, User approver);

    boolean rejectFpk(Fpk fpk, User rejecter);
}
