package com.empatkepala.service.impl;

import com.empatkepala.entity.OnlineTestEntity.Essay;
import com.empatkepala.entity.request.OnlineTestRequest.AddEssayRequest;
import com.empatkepala.repository.OnlineTestRepository.EssayRepository;
import com.empatkepala.service.OnlineTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by ARDI on 8/6/2017.
 */
@Service
public class OnlineTestServiceImpl implements OnlineTestService{

    @Autowired
    EssayRepository essayRepository;

    @Override
    public List<Essay> essayGetAllProblemsService() {
        return essayRepository.findAll();
    }

    @Override
    public void essayAddProblemService(
            @RequestBody AddEssayRequest addEssayRequest)
    {

    }


}
