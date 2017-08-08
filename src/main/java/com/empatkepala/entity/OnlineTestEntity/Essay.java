package com.empatkepala.entity.OnlineTestEntity;

import com.empatkepala.enumeration.Department;
import com.empatkepala.enumeration.ProblemDifficulty;

import javax.persistence.*;

/**
 * Created by ARDI on 8/6/2017.
 */
@Entity
public class Essay {

    @Id
    @GeneratedValue
    private long id;

    @Enumerated(EnumType.STRING)
    private Department department;

    private String problem;
    private String answer;

    @Enumerated(EnumType.STRING)
    private ProblemDifficulty problemDifficulty;

    public Essay(){

    }

    public Essay(Department department, String problem, String answer, ProblemDifficulty problemDifficulty) {
        this.department = department;
        this.problem = problem;
        this.answer = answer;
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
}
