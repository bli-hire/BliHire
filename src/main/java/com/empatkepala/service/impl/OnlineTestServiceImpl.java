package com.empatkepala.service.impl;

import com.empatkepala.entity.OnlineTestEntity.Essay;
import com.empatkepala.entity.OnlineTestEntity.MultipleChoices;
import com.empatkepala.entity.User;
import com.empatkepala.entity.request.OnlineTestRequest.AddEssayRequest;
import com.empatkepala.entity.request.OnlineTestRequest.AddMultipleChoicesRequest;
import com.empatkepala.enumeration.Department;
import com.empatkepala.enumeration.ProblemDifficulty;
import com.empatkepala.repository.OnlineTestRepository.EssayRepository;
import com.empatkepala.repository.OnlineTestRepository.MultipleChoicesRepository;
import com.empatkepala.service.OnlineTestService;
import com.empatkepala.utility.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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
    Helper helper;

    @Override
    public List<Essay> essayGetAllProblemsService() {
        return essayRepository.findAll();
    }

    @Override
    public void essayAddProblemService(
            @RequestBody AddEssayRequest addEssayRequest)
    {
        Essay essay = new Essay();
        essay.setDepartment(Department.valueOf(addEssayRequest.getDepartment()));
        essay.setProblem(addEssayRequest.getProblem());
        essay.setAnswer(addEssayRequest.getAnswer());
        essay.setProblemDifficulty(ProblemDifficulty.valueOf(addEssayRequest.getDifficulty()));

        essayRepository.save(essay);
    }

    @Override
    public void essayDeleteProblemService(@PathVariable long id) {
        essayRepository.delete(id);
    }

    @Override
    public List<Essay> essayfindAllProblemsByDepartmentService(String department) {
        Department dep = Department.valueOf(department);
        List<Essay> essays = essayRepository.findAllByDepartment(dep);
        return essays;
    }

    @Override
    public List<Essay> essayGetAllDepartmentProblemsService() {
        User user = helper.getCurrentUser();
        System.out.println(user.getName());
        Department department = user.getDepartment();
        List<Essay> essays = essayRepository.findAllByDepartment(department);
        return essays;
    }

    @Override
    public List<MultipleChoices> multipleChoicesGetAllProblemsService()
    {
        return multipleChoicesRepository.findAll();
    }

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

        multipleChoicesRepository.save(multipleChoices);
    }

    @Override
    public void multipleChoicesDeleteProblemService(
            @PathVariable long id)
    {
        multipleChoicesRepository.delete(id);
    }

    @Override
    public List<MultipleChoices> multipleChoicesfindAllProblemsByDepartmentService(
            String department)
    {
        Department dep = Department.valueOf(department);
        List<MultipleChoices> multipleChoicesList = multipleChoicesRepository.findAllByDepartment(dep);
        return multipleChoicesList;
    }


}
