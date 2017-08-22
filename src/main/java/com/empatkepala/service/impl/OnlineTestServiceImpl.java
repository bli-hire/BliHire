package com.empatkepala.service.impl;

import com.empatkepala.entity.OnlineTestEntity.*;
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
    TechnicalTestRepository technicalTestRepository;
    @Autowired
    CVRepository cvRepository;
    @Autowired
    Helper helper;
    @Autowired
    ProblemGeneratorServiceImpl problemGeneratorServiceImpl;

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
        essay.setCanBeGenerated(addEssayRequest.isCanBeGenerated());

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
        multipleChoices.setCanBeGenerated(addMultipleChoicesRequest.isCanBeGenerated());

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

    @Override
    public List<Problem> createProblemSetService(
            @RequestBody CreateProblemSetRequest createProblemSetRequest)
    {
        long numEssayEasy = createProblemSetRequest.getNumEssayEasy();
        long numEssayMedium = createProblemSetRequest.getNumEssayMedium();
        long numEssayHard = createProblemSetRequest.getNumEssayHard();

        if(numEssayEasy > essayRepository.findAllByProblemDifficulty(ProblemDifficulty.Easy).size()){
            numEssayEasy = essayRepository.findAllByProblemDifficulty(ProblemDifficulty.Easy).size();
        }
        if(numEssayMedium > essayRepository.findAllByProblemDifficulty(ProblemDifficulty.Medium).size()){
            numEssayMedium = essayRepository.findAllByProblemDifficulty(ProblemDifficulty.Medium).size();
        }
        if(numEssayHard > essayRepository.findAllByProblemDifficulty(ProblemDifficulty.Hard).size()){
            numEssayHard = essayRepository.findAllByProblemDifficulty(ProblemDifficulty.Hard).size();
        }

        long numMultipleChoicesEasy = createProblemSetRequest.getNumMultipleChoicesEasy();
        long numMultipleChoicesMedium = createProblemSetRequest.getNumMultipleChoicesMedium();
        long numMultipleChoicesHard = createProblemSetRequest.getNumMultipleChoicesHard();

        if(numMultipleChoicesEasy > multipleChoicesRepository.findAllByProblemDifficulty(ProblemDifficulty.Easy).size()){
            numMultipleChoicesEasy = multipleChoicesRepository.findAllByProblemDifficulty(ProblemDifficulty.Easy).size();
        }
        if(numMultipleChoicesMedium > multipleChoicesRepository.findAllByProblemDifficulty(ProblemDifficulty.Medium).size()){
            numMultipleChoicesMedium = multipleChoicesRepository.findAllByProblemDifficulty(ProblemDifficulty.Medium).size();
        }
        if(numMultipleChoicesHard > multipleChoicesRepository.findAllByProblemDifficulty(ProblemDifficulty.Hard).size()){
            numMultipleChoicesHard = multipleChoicesRepository.findAllByProblemDifficulty(ProblemDifficulty.Hard).size();
        }

        long numProblemGeneratorEasy = createProblemSetRequest.getNumProblemGeneratorEasy();
        long numProblemGeneratorMedium = createProblemSetRequest.getNumProblemGeneratorMedium();
        long numProblemGeneratorHard = createProblemSetRequest.getNumProblemGeneratorHard();

        List<Problem> problemset = new ArrayList<Problem>();
        problemset.addAll(helper.pickAndRandomEssay(essayRepository.findAllByProblemDifficulty(ProblemDifficulty.Easy), (int) numEssayEasy));
        problemset.addAll(helper.pickAndRandomEssay(essayRepository.findAllByProblemDifficulty(ProblemDifficulty.Medium), (int) numEssayMedium));
        problemset.addAll(helper.pickAndRandomEssay(essayRepository.findAllByProblemDifficulty(ProblemDifficulty.Hard), (int) numEssayHard));

        problemset.addAll(helper.pickAndRandomMultipleChoices(multipleChoicesRepository.findAllByProblemDifficulty(ProblemDifficulty.Easy), (int) numMultipleChoicesEasy));
        problemset.addAll(helper.pickAndRandomMultipleChoices(multipleChoicesRepository.findAllByProblemDifficulty(ProblemDifficulty.Medium), (int) numMultipleChoicesMedium));
        problemset.addAll(helper.pickAndRandomMultipleChoices(multipleChoicesRepository.findAllByProblemDifficulty(ProblemDifficulty.Hard), (int) numMultipleChoicesHard));

        problemset.addAll(helper.pickAndRandomProblemGenerator(problemGeneratorServiceImpl.getProblemGeneratorEasy(), (int) numProblemGeneratorEasy));


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

    // TODO GET SCORE FROM MULTIPLE CHOICES
    public long getScoreMultipleChoices(MultipleChoices multipleChoices, String answer)
    {
        if(multipleChoices.getRealAnswer() == answer){
            return multipleChoices.getMaxScore();
        }else return 0;
    }

    // TODO GET SCORE FROM ESSAY
    public long getScoreEssay(Essay essay, String answer)
    {
        return 0;
    }

    // TODO COUNT AND SET SCORE FROM TECHNICAL TEST
    public void countScore(TechnicalTest technicalTest)
    {
        long maxScore=0;
        long score=0;

        String scoreEachAnswer = "";
        List<Problem> problems = technicalTest.getProblems();

        String applicantAnswer = technicalTest.getApplicantAnswer();

        List<String> answerList = helper.parseAnswer(applicantAnswer);

        for(int i=0; i<problems.size();i++){
            long tmpScore;
            maxScore = maxScore + problems.get(i).getMaxScore();
            if(problems.get(i) instanceof MultipleChoices){
                tmpScore = getScoreMultipleChoices((MultipleChoices) problems.get(i), answerList.get(i));
                score = score + tmpScore;
                if(i!=problems.size()-1)
                    scoreEachAnswer = scoreEachAnswer + String.valueOf(tmpScore) + "|";
                else scoreEachAnswer = scoreEachAnswer + String.valueOf(tmpScore);
            }
            else if(problems.get(i) instanceof ProblemGenerator){
                tmpScore = getScoreMultipleChoices((MultipleChoices) problems.get(i), answerList.get(i));
                score = score + tmpScore;
                if(i!=problems.size()-1)
                    scoreEachAnswer = scoreEachAnswer + String.valueOf(tmpScore) + "|";
                else scoreEachAnswer = scoreEachAnswer + String.valueOf(tmpScore);
            }
            else{
                tmpScore = getScoreEssay((Essay) problems.get(i), answerList.get(i));
                score = score + tmpScore;
                if(i!=problems.size()-1)
                    scoreEachAnswer = scoreEachAnswer + String.valueOf(tmpScore) + "|";
                else scoreEachAnswer = scoreEachAnswer + String.valueOf(tmpScore);
            }

        }

        long persen = score*100/maxScore;

        technicalTest.setScore(persen);
        technicalTest.setScoreEachAnswer(scoreEachAnswer);

        technicalTestRepository.save(technicalTest);

    }



}
