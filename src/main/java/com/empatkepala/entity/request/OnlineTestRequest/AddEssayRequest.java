package com.empatkepala.entity.request.OnlineTestRequest;

import com.empatkepala.enumeration.Department;

/**
 * Created by ARDI on 8/6/2017.
 */
public class AddEssayRequest {

    private Department department;

    private String problem;
    private String answer;

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
}
