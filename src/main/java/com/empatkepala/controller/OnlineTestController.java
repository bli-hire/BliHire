package com.empatkepala.controller;

import com.empatkepala.entity.OnlineTestEntity.Essay;
import com.empatkepala.entity.OnlineTestEntity.MultipleChoices;
import com.empatkepala.entity.OnlineTestEntity.Problem;
import com.empatkepala.entity.request.OnlineTestRequest.*;
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

    // ------- ESSAY -------

    // TODO GET ALL ESSAY PROBLEMS
    @RequestMapping(value = "/essay/all-problems", method = RequestMethod.GET, produces = "application/json")
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

    // TODO DELETE ESSAY PROBLEM
    @RequestMapping(value = "/essay/{id}/delete", method = RequestMethod.POST)
    public void essayDeleteProblem(
            @PathVariable long id)
    {
        onlineTestService.essayDeleteProblemService(id);
    }

    // TODO FIND ALL ESSAY PROBLEM BY DEPARTMENT PARAM DEPARTMENT
    @RequestMapping(value = "/essay/{department}/problems", method = RequestMethod.GET, produces = "application/json")
    public List<Essay> essayfindAllProblemsByDepartment(
            @PathVariable String department)
    {
        return onlineTestService.essayfindAllProblemsByDepartmentService(department);
    }

    // TODO GET ALL ESSAY PROBLEM BY DEPARTMENT
    @RequestMapping(value = "/essay/problems", method = RequestMethod.GET, produces = "application/json")
    public List<Essay> essayGetAllDepartmentProblems()
    {
        return onlineTestService.essayGetAllDepartmentProblemsService();
    }

    // TODO EDIT ESSAY PROBLEM
    @RequestMapping(value = "/essay/{id}/edit", method = RequestMethod.POST)
    public void essayEditProblem(
            @PathVariable long id,
            @RequestBody EditEssayRequest editEssayRequest)
    {
        onlineTestService.essayEditProblemService(id, editEssayRequest);
    }

    // ------- Multiple Choices -------

    // TODO GET ALL MULTIPLE CHOICES PROBLEMS
    @RequestMapping(value = "/multiple-choices/problems", method = RequestMethod.GET, produces = "application/json")
    public List<MultipleChoices> multipleChoicesGetAllProblems(){
        return onlineTestService.multipleChoicesGetAllProblemsService();
    }

    // TODO ADD MULTIPLE CHOICES PROBLEM
    @RequestMapping(value = "/multiple-choices/add-problem", method = RequestMethod.POST)
    public void multipleChoicesAddProblem(
            @RequestBody AddMultipleChoicesRequest addMultipleChoicesRequest
            )
    {
        onlineTestService.multipleChoicesAddProblemService(addMultipleChoicesRequest);
    }

    // TODO DELETE MULTIPLE CHOICES PROBLEM
    @RequestMapping(value = "/multiple-choices/{id}/delete", method = RequestMethod.POST)
    public void multipleChoicesDeleteProblem(
            @PathVariable long id)
    {
        onlineTestService.multipleChoicesDeleteProblemService(id);
    }

    // TODO FIND ALL MULTIPLE CHOICES PROBLEM BY DEPARTMENT PARAM DEPARTMENT
    @RequestMapping(value = "/multiple-choices/{department}/problems", method = RequestMethod.GET, produces = "application/json")
    public List<MultipleChoices> multipleChoicesfindAllProblemsByDepartment(
            @PathVariable String department)
    {
        return onlineTestService.multipleChoicesfindAllProblemsByDepartmentService(department);
    }

    // TODO EDIT MULTIPLE CHOICES PROBLEM
    @RequestMapping(value = "/multiple-choices/{id}/edit", method = RequestMethod.POST)
    public void multipleChoicesEditProblem(
            @PathVariable long id,
            @RequestBody EditMultipleChoicesRequest editMultipleChoicesRequest)
    {
        onlineTestService.multipleChoicesEditProblemService(id, editMultipleChoicesRequest);
    }

    // ------- ALL SERVICE -------

    // TODO CREATE PROBLEM SET
    @RequestMapping(value = "/create-problemset", produces = "application/json")
    public List<Problem> createProblemSet(
            @RequestBody CreateProblemSetRequest createProblemSetRequest)
    {
        return onlineTestService.createProblemSetService(createProblemSetRequest);
    }
}
