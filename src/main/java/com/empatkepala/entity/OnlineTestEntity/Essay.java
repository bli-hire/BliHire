package com.empatkepala.entity.OnlineTestEntity;

import com.empatkepala.enumeration.Department;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by ARDI on 8/6/2017.
 */
@Entity
public class Essay {

    @Id
    @GeneratedValue
    private long id;

    private Department department;

    private String problem;
    private String answer;

    public Essay(Department department, String problem, String answer) {
        this.department = department;
        this.problem = problem;
        this.answer = answer;
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
}
