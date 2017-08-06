package com.empatkepala.service;

import com.empatkepala.entity.OnlineTestEntity.Essay;
import com.empatkepala.entity.request.OnlineTestRequest.AddEssayRequest;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by ARDI on 8/6/2017.
 */
public interface OnlineTestService {

    public List<Essay> essayGetAllProblemsService();

    public void essayAddProblemService(
            @RequestBody AddEssayRequest addEssayRequest
            );

}
