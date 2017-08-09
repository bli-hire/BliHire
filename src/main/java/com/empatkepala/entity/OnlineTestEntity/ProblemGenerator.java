package com.empatkepala.entity.OnlineTestEntity;

import com.empatkepala.enumeration.Department;
import com.empatkepala.enumeration.ProblemDifficulty;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProblemGenerator extends Problem{

    @Enumerated(EnumType.STRING)
    private Department department;

    private String problem;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String realAnswer;

    @Enumerated(EnumType.STRING)
    private ProblemDifficulty problemDifficulty;

    public ProblemGenerator(Department department, String problem, int answerIndex, List<String> answerList, ProblemDifficulty problemDifficulty) {
        this.department = department;
        this.problem = problem;
        this.answerA = answerList.get(0);
        this.answerB = answerList.get(1);
        this.answerC = answerList.get(2);
        this.answerD = answerList.get(3);

        this.realAnswer = answerList.get(answerIndex);

        this.problemDifficulty = problemDifficulty;
    }


    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getRealAnswer() {
        return realAnswer;
    }

    public void setRealAnswer(String realAnswer) {
        this.realAnswer = realAnswer;
    }

    public ProblemDifficulty getProblemDifficulty() {
        return problemDifficulty;
    }

    public void setProblemDifficulty(ProblemDifficulty problemDifficulty) {
        this.problemDifficulty = problemDifficulty;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
