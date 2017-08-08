package com.empatkepala.entity.request.OnlineTestRequest;

import com.empatkepala.enumeration.Department;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * Created by ARDI on 8/6/2017.
 */
public class AddEssayRequest {

    private String department;

    private String problem;
    private String answer;

    private String difficulty;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
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

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
