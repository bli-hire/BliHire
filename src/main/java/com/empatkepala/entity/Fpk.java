package com.empatkepala.entity;

import com.empatkepala.entity.User;
import com.empatkepala.enumeration.Department;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import org.joda.time.DateTime;

/**
 * Created by ALz on 3/11/2017.
 */

@Entity
@Table(name = "fpk")
public class Fpk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFpk;

    private int numberOfPerson;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdDate = new DateTime();

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime dateNeeded;

    private String jobPositionRequester;
    private String reason;
    private String fitnessWithMpp;
    private String employeeStatus;
    private String school;
    private String workExperience;
    private String skillKnowledge;
    private String completeness;
    private String comment;
    private Department department;
    private boolean statusAccept;
    private boolean accept;
    private boolean approveCeo;
    private boolean statusCeoApprove;
    private boolean approveHead;
    private boolean statusHeadApprove;

//    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne(cascade = CascadeType.MERGE)
    private User requestedBy;
//    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne(cascade = CascadeType.MERGE)
    private User ceoApproved;
    @ManyToOne(cascade = CascadeType.MERGE)
    private User headApproved;
    @ManyToOne(cascade = CascadeType.MERGE)
    private User hrdAccepted;

    public Fpk(){}

    public Fpk(int positionNeeded,String reason,String fitnessWithMpp,String employeeStatus,
               String school,String workExperience,String skillKnowledge,String completeness,
               User requestedBy,Department department,DateTime needed, String jobPositionRequester) {
        this.numberOfPerson = positionNeeded;
        this.reason = reason;
        this.fitnessWithMpp = fitnessWithMpp;
        this.employeeStatus = employeeStatus;
        this.school = school;
        this.workExperience = workExperience;
        this.skillKnowledge = skillKnowledge;
        this.completeness = completeness;
        this.requestedBy = requestedBy;
        this.department = department;
        this.dateNeeded = needed;
        this.jobPositionRequester = jobPositionRequester;
    }

    public boolean isStatusAccept() {
        return statusAccept;
    }

    public void setStatusAccept(boolean statusAccept) {
        this.statusAccept = statusAccept;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
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

    public DateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(DateTime date) {
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

    public DateTime getDateNeeded() {
        return dateNeeded;
    }

    public void setDateNeeded(DateTime
                                      dateNeeded) {
        this.dateNeeded = dateNeeded;
    }

    public String getJobPositionRequester() {
        return jobPositionRequester;
    }

    public void setJobPositionRequester(String jabatanPemohon) {
        this.jobPositionRequester = jabatanPemohon;
    }

    public String getCompleteness() {
        return completeness;
    }

    public void setIdFpk(long idFpk) {
        this.idFpk = idFpk;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public User getCeoApproved() {
        return ceoApproved;
    }

    public void setCeoApproved(User ceoApproved) {
        this.ceoApproved = ceoApproved;
    }

    public User getHeadApproved() {
        return headApproved;
    }

    public void setHeadApproved(User headApproved) {
        this.headApproved = headApproved;
    }

    public User getHrdAccepted() {
        return hrdAccepted;
    }

    public void setHrdAccepted(User hrdAccepted) {
        this.hrdAccepted = hrdAccepted;
    }

    public boolean isStatusCeoApprove() {
        return statusCeoApprove;
    }

    public void setStatusCeoApprove(boolean statusCeoApprove) {
        this.statusCeoApprove = statusCeoApprove;
    }

    public boolean isStatusHeadApprove() {
        return statusHeadApprove;
    }

    public void setStatusHeadApprove(boolean statusHeadApprove) {
        this.statusHeadApprove = statusHeadApprove;
    }
}
