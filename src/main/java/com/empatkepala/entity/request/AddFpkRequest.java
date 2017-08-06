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
    private boolean reject;
    private boolean accept;
    private boolean approveCeo;
    private boolean approveHead;
    private long idUserRequested;
    private long idCeoApporved;
    private long idHrdAcceptedd;
    private long idHadDepartmentApproved;


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
        return reject;
    }

    public void setReject(boolean reject) {
        this.reject = reject;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

    public boolean isApproveCeo() {
        return approveCeo;
    }

    public void setApproveCeo(boolean approveCeo) {
        this.approveCeo = approveCeo;
    }

    public boolean isApproveHead() {
        return approveHead;
    }

    public void setApproveHead(boolean approveHead) {
        this.approveHead = approveHead;
    }

    public long getIdCeoApporved() {
        return idCeoApporved;
    }

    public void setIdCeoApporved(long idCeoApporved) {
        this.idCeoApporved = idCeoApporved;
    }

    public long getIdHrdAcceptedd() {
        return idHrdAcceptedd;
    }

    public void setIdHrdAcceptedd(long idHrdAcceptedd) {
        this.idHrdAcceptedd = idHrdAcceptedd;
    }

    public long getIdHadDepartmentApproved() {
        return idHadDepartmentApproved;
    }

    public void setIdHadDepartmentApproved(long idHadDepartmentApproved) {
        this.idHadDepartmentApproved = idHadDepartmentApproved;
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
