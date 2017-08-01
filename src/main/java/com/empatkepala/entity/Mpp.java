package com.empatkepala.entity;

import com.empatkepala.enumeration.Department;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Juan on 3/11/17.
 */
@Entity
@Table(name = "mpp")
public class Mpp {

    @Id
    @GeneratedValue
    private long id;

    private Date createdDate = new Date();
    private long numberOfPerson;
    private Department department;
    private String reason;
    private String mainResponsibility;
    private String education;
    private String experience;
    private String knowledge;
    private String employeeStatus;
    private int expectedJoin;
    private int pcAmmount;
    private String pcSpec;
    private boolean isReject;
    private boolean isAccept;

    @ManyToOne(cascade = CascadeType.MERGE)
    private User requestedBy;

    @ManyToOne(cascade = CascadeType.MERGE)
    private User approvedBy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public long getNumberOfPerson() {
        return numberOfPerson;
    }

    public void setNumberOfPerson(long numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getMainResponsibility() {
        return mainResponsibility;
    }

    public void setMainResponsibility(String mainResponsibility) {
        this.mainResponsibility = mainResponsibility;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public int getExpectedJoin() {
        return expectedJoin;
    }

    public void setExpectedJoin(int expectedJoin) {
        this.expectedJoin = expectedJoin;
    }

    public int getPcAmmount() {
        return pcAmmount;
    }

    public void setPcAmmount(int pcAmmount) {
        this.pcAmmount = pcAmmount;
    }

    public String getPcSpec() {
        return pcSpec;
    }

    public void setPcSpec(String pcSpec) {
        this.pcSpec = pcSpec;
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

    public void
    setApprovedBy(User approvedBy) {
        this.approvedBy = approvedBy;
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
}
