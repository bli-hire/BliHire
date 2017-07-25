package com.empatkepala.entity;

import com.empatkepala.entity.User;
import com.empatkepala.enumeration.Department;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ALz on 3/11/2017.
 */

@Entity
public class Fpk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFpk;

    private int numberOfPerson;
    private Date createdDate = new Date();
    private String reason;
    private String fitnessWithMpp;
    private String employeeStatus;
    private String school;
    private String workExperience;
    private String skillKnowledge;
    private String completeness;
    private Department department;
    private boolean isReject;
    private boolean isAccept;

//    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne(cascade = CascadeType.MERGE)
    private User requestedBy;
//    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne(cascade = CascadeType.MERGE)
    private User approvedBy;

    public Fpk(){}

    public Fpk(int positionNeeded,String reason,String fitnessWithMpp,String employeeStatus,
               String school,String workExperience,String skillKnowledge,String completeness,
               User requestedBy) {
        this.numberOfPerson = positionNeeded;
        this.reason = reason;
        this.fitnessWithMpp = fitnessWithMpp;
        this.employeeStatus = employeeStatus;
        this.school = school;
        this.workExperience = workExperience;
        this.skillKnowledge = skillKnowledge;
        this.completeness = completeness;
        this.requestedBy = requestedBy;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public long getIdFpk() {
        return idFpk;
    }

    public void setIdFpk(Long idFpk) {
        this.idFpk = idFpk;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public void setNumberOfPerson(int positionNeeded) {
        this.numberOfPerson = positionNeeded;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date date) {
        this.createdDate = date;
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

    public String isCompleteness() {
        return completeness;
    }

    public void setCompleteness(String completeness) {
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
