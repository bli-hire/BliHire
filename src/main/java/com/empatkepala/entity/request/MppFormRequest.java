package com.empatkepala.entity.request;

import com.empatkepala.entity.User;

/**
 * Created by Juan on 3/11/17.
 */
public class MppFormRequest {

    private long numberOfPerson;
    private String reason;
    private String mainResponsibility;
    private String education;
    private String experience;
    private String knowledge;
    private String employeeStatus;
    private int expectedJoin;
    private int pcAmmount;
    private String pcSpec;
    private Long idRequestedBy;
    private Long idApprovedBy;

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

    public Long getIdRequestedBy() {
        return idRequestedBy;
    }

    public void setIdRequestedBy(Long idRequestedBy) {
        this.idRequestedBy = idRequestedBy;
    }

    public Long getIdApprovedBy() {
        return idApprovedBy;
    }

    public void setIdApprovedBy(Long idApprovedBy) {
        this.idApprovedBy = idApprovedBy;
    }
}
