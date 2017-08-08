package com.empatkepala.entity.OnlineTestEntity;

import com.empatkepala.enumeration.Department;
import com.empatkepala.enumeration.ProblemDifficulty;

import javax.persistence.*;

/**
 * Created by ARDI on 8/6/2017.
 */
@Entity
public class Essay extends Problem{



    @Enumerated(EnumType.STRING)
    private Department department;

    private String problem;
    private String answer;

    @Enumerated(EnumType.STRING)
    private ProblemDifficulty problemDifficulty;

    private boolean canBeGenerated;

    public Essay(){

    }

    public Essay(Department department, String problem, String answer, ProblemDifficulty problemDifficulty, boolean canBeGenerated) {
        this.department = department;
        this.problem = problem;
        this.answer = answer;
        this.problemDifficulty = problemDifficulty;
        this.canBeGenerated = canBeGenerated;
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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public ProblemDifficulty getProblemDifficulty() {
        return problemDifficulty;
    }

    public void setProblemDifficulty(ProblemDifficulty problemDifficulty) {
        this.problemDifficulty = problemDifficulty;
    }

    public boolean isCanBeGenerated() {
        return canBeGenerated;
    }

    public void setCanBeGenerated(boolean canBeGenerated) {
        this.canBeGenerated = canBeGenerated;
    }
}
