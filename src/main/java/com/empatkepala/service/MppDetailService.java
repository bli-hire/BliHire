package com.empatkepala.service;

import com.empatkepala.entity.MppDetail;
import com.empatkepala.entity.User;
import com.empatkepala.entity.request.MppDetailRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Juan on 8/4/17.
 */

@Service
public interface MppDetailService {

    boolean editMppDetail(Long mppDetailId, MppDetailRequest mppDetailRequest, User editor);

    MppDetail getMppDetailById(Long id);

}
