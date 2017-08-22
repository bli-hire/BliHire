package com.empatkepala.service;

import com.empatkepala.entity.OnlineTestEntity.Essay;
import com.empatkepala.entity.OnlineTestEntity.MultipleChoices;
import com.empatkepala.entity.OnlineTestEntity.Problem;
import com.empatkepala.entity.request.OnlineTestRequest.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by ARDI on 8/6/2017.
 */
public interface OnlineTestService {

    // ------- Essay -------

    public List<Essay> essayGetAllProblemsService();

    public void essayAddProblemService(
            @RequestBody AddEssayRequest addEssayRequest
            );

    public void essayDeleteProblemService(
            @PathVariable long id);

    public List<Essay> essayfindAllProblemsByDepartmentService(String department);

    public List<Essay> essayGetAllDepartmentProblemsService();

    public void essayEditProblemService(
            @PathVariable long id,
            @RequestBody EditEssayRequest editEssayRequest);

    // ------- Multiple Choices -------

    public List<MultipleChoices> multipleChoicesGetAllProblemsService();

    public void multipleChoicesAddProblemService(
            @RequestBody AddMultipleChoicesRequest addMultipleChoicesRequest
            );

    public void multipleChoicesDeleteProblemService(
            @PathVariable long id);

    public List<MultipleChoices> multipleChoicesfindAllProblemsByDepartmentService(String department);

    public void multipleChoicesEditProblemService(
            @PathVariable long id,
            @RequestBody EditMultipleChoicesRequest editMultipleChoicesRequest
            );

    public List<Problem> createProblemSetService(
            @RequestBody CreateProblemSetRequest createProblemSetRequest
            );


    // ------ OTHER SERVICES -------

    public void createTechnicalTestService(
            @RequestBody CreateProblemSetRequest createProblemSetRequest);

}
