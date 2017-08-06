package com.empatkepala.controller;

import com.empatkepala.entity.OnlineTestEntity.Essay;
import com.empatkepala.entity.request.OnlineTestRequest.AddEssayRequest;
import com.empatkepala.service.OnlineTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ARDI on 8/6/2017.
 */
@RestController
@RequestMapping(value = "/online-test")
@CrossOrigin(origins = "*")
public class OnlineTestController {

    @Autowired
    OnlineTestService onlineTestService;

    // TODO GET ALL ESSAY PROBLEMS
    @RequestMapping(value = "/essay/problems", method = RequestMethod.GET, produces = "application/json")
    public List<Essay> essayGetAllProblems(){
        return onlineTestService.essayGetAllProblemsService();
    }

    // TODO ADD ESSAY PROBLEM
    @RequestMapping(value = "/essay/add-problem", method = RequestMethod.POST)
    public void essayAddProblem(
            @RequestBody AddEssayRequest addEssayRequest
            )
    {
        onlineTestService.essayAddProblemService(addEssayRequest);
    }
}
