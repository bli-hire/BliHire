package com.empatkepala.entity.OnlineTestEntity;

import com.empatkepala.enumeration.Department;
import com.empatkepala.enumeration.ProblemDifficulty;

import javax.persistence.*;

/**
 * Created by ARDI on 8/7/2017.
 */
@Entity
public class MultipleChoices {

    @Id
    @GeneratedValue
    private long id;

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

    public MultipleChoices(){

    }

    public MultipleChoices(Department department, String problem, String answerA, String answerB, String answerC, String answerD, String realAnswer, ProblemDifficulty problemDifficulty) {
        this.department = department;
        this.problem = problem;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.realAnswer = realAnswer;
        this.problemDifficulty = problemDifficulty;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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

}
