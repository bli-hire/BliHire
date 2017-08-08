package com.empatkepala.service.impl;

import com.empatkepala.entity.OnlineTestEntity.Essay;
import com.empatkepala.entity.OnlineTestEntity.MultipleChoices;
import com.empatkepala.entity.OnlineTestEntity.Problem;
import com.empatkepala.entity.OnlineTestEntity.TechnicalTest;
import com.empatkepala.entity.User;
import com.empatkepala.entity.request.OnlineTestRequest.*;
import com.empatkepala.enumeration.Department;
import com.empatkepala.enumeration.ProblemDifficulty;
import com.empatkepala.repository.CVRepository;
import com.empatkepala.repository.OnlineTestRepository.EssayRepository;
import com.empatkepala.repository.OnlineTestRepository.MultipleChoicesRepository;
import com.empatkepala.repository.OnlineTestRepository.TechnicalTestRepository;
import com.empatkepala.service.OnlineTestService;
import com.empatkepala.utility.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ARDI on 8/6/2017.
 */
@Service
public class OnlineTestServiceImpl implements OnlineTestService{

    @Autowired
    EssayRepository essayRepository;
    @Autowired
    MultipleChoicesRepository multipleChoicesRepository;
    @Autowired
    CVRepository cvRepository;
    @Autowired
    TechnicalTestRepository technicalTestRepository;
    @Autowired
    Helper helper;

    // ------- ESSAY -------

    // TODO GET ALL ESSAY PROBLEMS
    @Override
    public List<Essay> essayGetAllProblemsService() {
        return essayRepository.findAll();
    }

    // TODO ADD ESSAY PROBLEM
    @Override
    public void essayAddProblemService(
            @RequestBody AddEssayRequest addEssayRequest)
    {
        Essay essay = new Essay();
        essay.setDepartment(Department.valueOf(addEssayRequest.getDepartment()));
        essay.setProblem(addEssayRequest.getProblem());
        essay.setAnswer(addEssayRequest.getAnswer());
        essay.setProblemDifficulty(ProblemDifficulty.valueOf(addEssayRequest.getDifficulty()));
        essay.setCanBeGenerated(addEssayRequest.isCanBeGenerated());

        essayRepository.save(essay);
    }

    // TODO DELETE ESSAY PROBLEM
    @Override
    public void essayDeleteProblemService(@PathVariable long id) {
        essayRepository.delete(id);
    }

    // TODO FIND ALL ESSAY PROBLEM BY DEPARTMENT PARAM DEPARTMENT
    @Override
    public List<Essay> essayfindAllProblemsByDepartmentService(String department) {
        Department dep = Department.valueOf(department);
        List<Essay> essays = essayRepository.findAllByDepartment(dep);
        return essays;
    }

    // TODO GET ALL ESSAY PROBLEM BY DEPARTMENT
    @Override
    public List<Essay> essayGetAllDepartmentProblemsService() {
        User user = helper.getCurrentUser();
        System.out.println(user.getName());
        Department department = user.getDepartment();
        List<Essay> essays = essayRepository.findAllByDepartment(department);
        return essays;
    }

    // TODO EDIT ESSAY PROBLEM
    @Override
    public void essayEditProblemService(
            @PathVariable long id,
            @RequestBody EditEssayRequest editEssayRequest)
    {
        Essay essay = essayRepository.findOne(id);

        essay.setProblem(editEssayRequest.getProblem());
        essay.setAnswer(editEssayRequest.getAnswer());
        essay.setProblemDifficulty(ProblemDifficulty.valueOf(editEssayRequest.getDifficulty()));
        essay.setCanBeGenerated(editEssayRequest.isCanBeGenerated());

        essayRepository.save(essay);
    }


    // ------- Multiple Choices -------

    // TODO GET ALL MULTIPLE CHOICES PROBLEMS
    @Override
    public List<MultipleChoices> multipleChoicesGetAllProblemsService()
    {
        return multipleChoicesRepository.findAll();
    }

    // TODO ADD MULTIPLE CHOICES PROBLEM
    @Override
    public void multipleChoicesAddProblemService(
            @RequestBody AddMultipleChoicesRequest addMultipleChoicesRequest)
    {
        MultipleChoices multipleChoices = new MultipleChoices();
        multipleChoices.setDepartment(Department.valueOf(addMultipleChoicesRequest.getDepartment()));
        multipleChoices.setProblem(addMultipleChoicesRequest.getProblem());
        multipleChoices.setAnswerA(addMultipleChoicesRequest.getAnswerA());
        multipleChoices.setAnswerB(addMultipleChoicesRequest.getAnswerB());
        multipleChoices.setAnswerC(addMultipleChoicesRequest.getAnswerC());
        multipleChoices.setAnswerD(addMultipleChoicesRequest.getAnswerD());
        multipleChoices.setRealAnswer(addMultipleChoicesRequest.getRealAnswer());
        multipleChoices.setProblemDifficulty(ProblemDifficulty.valueOf(addMultipleChoicesRequest.getDifficulty()));
        multipleChoices.setCanBeGenerated(addMultipleChoicesRequest.isCanBeGenerated());

        multipleChoicesRepository.save(multipleChoices);
    }

    // TODO DELETE MULTIPLE CHOICES PROBLEM
    @Override
    public void multipleChoicesDeleteProblemService(
            @PathVariable long id)
    {
        multipleChoicesRepository.delete(id);
    }

    // TODO FIND ALL MULTIPLE CHOICES PROBLEM BY DEPARTMENT PARAM DEPARTMENT
    @Override
    public List<MultipleChoices> multipleChoicesfindAllProblemsByDepartmentService(
            String department)
    {
        Department dep = Department.valueOf(department);
        List<MultipleChoices> multipleChoicesList = multipleChoicesRepository.findAllByDepartment(dep);
        return multipleChoicesList;
    }

    // TODO EDIT MULTIPLE CHOICES PROBLEM
    @Override
    public void multipleChoicesEditProblemService(
            @PathVariable long id,
            @RequestBody EditMultipleChoicesRequest editMultipleChoicesRequest)
    {
        MultipleChoices multipleChoices = multipleChoicesRepository.findOne(id);

        multipleChoices.setProblem(editMultipleChoicesRequest.getProblem());
        multipleChoices.setAnswerA(editMultipleChoicesRequest.getAnswerA());
        multipleChoices.setAnswerB(editMultipleChoicesRequest.getAnswerB());
        multipleChoices.setAnswerC(editMultipleChoicesRequest.getAnswerC());
        multipleChoices.setAnswerD(editMultipleChoicesRequest.getAnswerD());
        multipleChoices.setRealAnswer(editMultipleChoicesRequest.getRealAnswer());
        multipleChoices.setProblemDifficulty(ProblemDifficulty.valueOf(editMultipleChoicesRequest.getDifficulty()));
        multipleChoices.setCanBeGenerated(editMultipleChoicesRequest.isCanBeGenerated());

        multipleChoicesRepository.save(multipleChoices);
    }


    // ------- OTHER SERVICES -------

    // TODO CREATE PROBLEM SET
    public List<Problem> createProblemSetService(
            @RequestBody CreateProblemSetRequest createProblemSetRequest)
    {
        long numEssayEasy = createProblemSetRequest.getNumEssayEasy();
        long numEssayMedium = createProblemSetRequest.getNumEssayMedium();
        long numEssayHard = createProblemSetRequest.getNumEssayHard();

        long numMultipleChoicesEasy = createProblemSetRequest.getNumMultipleChoicesEasy();
        long numMultipleChoicesMedium = createProblemSetRequest.getNumMultipleChoicesMedium();
        long numMultipleChoicesHard = createProblemSetRequest.getNumMultipleChoicesHard();

        List<Problem> problemset = new ArrayList<Problem>();
        problemset.addAll(helper.pickAndRandomEssay(essayRepository.findAllByProblemDifficulty(ProblemDifficulty.Easy), (int) numEssayEasy));
        problemset.addAll(helper.pickAndRandomEssay(essayRepository.findAllByProblemDifficulty(ProblemDifficulty.Medium), (int) numEssayMedium));
        problemset.addAll(helper.pickAndRandomEssay(essayRepository.findAllByProblemDifficulty(ProblemDifficulty.Hard), (int) numEssayHard));

        problemset.addAll(helper.pickAndRandomMultipleChoices(multipleChoicesRepository.findAllByProblemDifficulty(ProblemDifficulty.Easy), (int) numMultipleChoicesEasy));
        problemset.addAll(helper.pickAndRandomMultipleChoices(multipleChoicesRepository.findAllByProblemDifficulty(ProblemDifficulty.Medium), (int) numMultipleChoicesMedium));
        problemset.addAll(helper.pickAndRandomMultipleChoices(multipleChoicesRepository.findAllByProblemDifficulty(ProblemDifficulty.Hard), (int) numMultipleChoicesHard));

        return problemset;

    }

    // TODO CREATE TECHNICAL TEST
    @Override
    public void createTechnicalTestService(
            @RequestBody CreateProblemSetRequest createProblemSetRequest)
    {
        List<Problem> problemSet = createProblemSetService(createProblemSetRequest);
        TechnicalTest technicalTest = new TechnicalTest();

        technicalTest.setProblems(problemSet);
        technicalTest.setCv(cvRepository.findOne(createProblemSetRequest.getIdCV()));

        technicalTestRepository.save(technicalTest);

    }


}
