package com.empatkepala.service;

import com.empatkepala.entity.Fpk;
import com.empatkepala.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ALz on 3/11/2017.
 */
@Service
public interface FpkService{
    List getAllData();
    Fpk getFpk(Long id);
    void save(Fpk data);
    void update(Fpk data);
    void delete(Long id);
    User getRequestUserByFpk(Long id);
    User getApprovedUserByFpk(Long id);
}
