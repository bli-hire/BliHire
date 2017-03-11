package com.empatkepala.repository;

import com.empatkepala.entity.User;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ALz on 3/11/2017.
 */

@Entity
public class Fpk {

    @Id
    @GeneratedValue
    private int idFpk;
    private int position;
    private Date date;
    private String reason;
    private String fitnessWithMpp;
    private String employeeStatus;
    private String school;
    private String workExperience;
    private String skillKnowledge;
    private boolean completeness;

    @ManyToOne(fetch = FetchType.LAZY)
    private User requestedBy;
    @ManyToOne(fetch = FetchType.LAZY)
    private User approvedBy;

    public int getIdFpk() {
        return idFpk;
    }

    public void setIdFpk(int idFpk) {
        this.idFpk = idFpk;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getFitnessWithMpp() {
        return fitnessWithMpp;
    }

    public void setFitnessWithMpp(String fitnessWithMpp) {
        this.fitnessWithMpp = fitnessWithMpp;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getSkillKnowledge() {
        return skillKnowledge;
    }

    public void setSkillKnowledge(String skillKnowledge) {
        this.skillKnowledge = skillKnowledge;
    }

    public boolean isCompleteness() {
        return completeness;
    }

    public void setCompleteness(boolean completeness) {
        this.completeness = completeness;
    }

    public User getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(User requestedBy) {
        this.requestedBy = requestedBy;
    }

    public User getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(User approvedBy) {
        this.approvedBy = approvedBy;
    }
}
