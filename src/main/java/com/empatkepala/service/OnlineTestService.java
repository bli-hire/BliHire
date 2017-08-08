package com.empatkepala.service;

import com.empatkepala.entity.OnlineTestEntity.Essay;
import com.empatkepala.entity.OnlineTestEntity.MultipleChoices;
import com.empatkepala.entity.request.OnlineTestRequest.AddEssayRequest;
import com.empatkepala.entity.request.OnlineTestRequest.AddMultipleChoicesRequest;
import org.springframework.web.bind.annotation.PathVariable;
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

    public void essayDeleteProblemService(
            @PathVariable long id);

    public List<Essay> essayfindAllProblemsByDepartmentService(String department);

    public List<Essay> essayGetAllDepartmentProblemsService();

    public List<MultipleChoices> multipleChoicesGetAllProblemsService();

    public void multipleChoicesAddProblemService(
            @RequestBody AddMultipleChoicesRequest addMultipleChoicesRequest
            );

    public void multipleChoicesDeleteProblemService(
            @PathVariable long id);

    public List<MultipleChoices> multipleChoicesfindAllProblemsByDepartmentService(String department);

}
