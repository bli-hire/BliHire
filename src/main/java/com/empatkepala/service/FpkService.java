package com.empatkepala.service;

import com.empatkepala.entity.Fpk;
import com.empatkepala.entity.User;
import com.empatkepala.entity.request.AddFpkRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.List;

/**
 * Created by ALz on 3/11/2017.
 */
@Service
public interface FpkService{

    List getAllData();

    Fpk getFpk(Long id);

    void addFpk(@RequestBody AddFpkRequest addFpkRequest);

    void update(Fpk data);

    void delete(Long id);

    User getRequestUserByFpk(Long id);

    User getApprovedUserByFpk(Long id);

    User getRequestedUserByFpkId(Long id);

    boolean editFpk(AddFpkRequest fpkRequest, User editor, Fpk fpkToEdit);

    boolean approveFpk(Fpk fpk, User approver);

    boolean rejectFpk(Fpk fpk, User rejecter);
}
