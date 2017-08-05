package com.empatkepala.entity.request;

import com.empatkepala.enumeration.Department;
import org.joda.time.DateTime;

import java.util.Date;

/**
 * Created by ALz on 3/11/2017.
 */
public class AddFpkRequest {

    private int position;
    private String dateNeeded;
    private String jobPositionRequester;
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
    private boolean needApproveCeo;
    private boolean needApproveHead;
    private long idUserRequested;


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

    public String getDateNeeded() {
        return dateNeeded;
    }

    public void setDateNeeded(String dateNeeded) {
        this.dateNeeded = dateNeeded;
    }

    public String getJobPositionRequester() {
        return jobPositionRequester;
    }

    public void setJobPositionRequester(String jobPositionRequester) {
        this.jobPositionRequester = jobPositionRequester;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public boolean isReject() {
        return isReject;
    }

    public void setReject(boolean reject) {
        isReject = reject;
    }

    public boolean isAccept() {
        return isAccept;
    }

    public void setAccept(boolean accept) {
        isAccept = accept;
    }

    public boolean isNeedApproveCeo() {
        return needApproveCeo;
    }

    public void setNeedApproveCeo(boolean needApproveCeo) {
        this.needApproveCeo = needApproveCeo;
    }

    public boolean isNeedApproveHead() {
        return needApproveHead;
    }

    public void setNeedApproveHead(boolean needApproveHead) {
        this.needApproveHead = needApproveHead;
    }

    public static String getRequestBody() {
        return "AddFpkRequest{" +
                "position" +
                ", dateNeeded" +
                ", jobPositionRequester" +
                ", reason" +
                ", fitnessWithMpp" +
                ", employeeStatus" +
                ", school" +
                ", workExperience" +
                ", skillKnowledge" +
                ", completeness" +
                ", department" +
                ", isReject" +
                ", isAccept" +
                ", needApproveCeo" +
                ", needApproveHead" +
                ", idUserRequested" +
                '}';
    }

    public static String getHeaderContentType(){
        return "Content-Type : Application/json";
    }
}
