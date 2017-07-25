package com.empatkepala.entity.request;

/**
 * Created by ALz on 3/11/2017.
 */
public class AddFpkRequest {

    private int position;
    private String reason;
    private String fitnessWithMpp;
    private String employeeStatus;
    private String school;
    private String workExperience;
    private String skillKnowledge;
//    private long idUserApproved;
    private long idUserRequested;
    private String completeness;


    public long getIdUserRequested() {
        return idUserRequested;
    }

    public void setIdUserRequested(long idUser) {
        this.idUserRequested = idUser;
    }

//    public long getIdUserApproved() {
//        return idUserApproved;
//    }
//
//    public void setIdUserApproved(long idUserApproved) {
//        this.idUserApproved = idUserApproved;
//    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
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

    public String getCompleteness() {
        return completeness;
    }

    public void setCompleteness(String completeness) {
        this.completeness = completeness;
    }

}
