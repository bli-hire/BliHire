package com.empatkepala.entity.request;

/**
 * Created by Juan on 8/4/17.
 */
public class MppDetailRequest {
    private String position;
    private int numberOfPerson;
    private String reason;
    private String mainResponsibility;
    private String education;
    private String experience;
    private String knowledge;
    private String employeeStatus;
    private int expectedJoin;
    private int pcAmmount;
    private String pcSpec;
    private ExpectJoinRequest expectJoin;
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public void setNumberOfPerson(int numberOfPerson) {
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

    public ExpectJoinRequest getExpectJoin() {
        return expectJoin;
    }

    public void setExpectJoin(ExpectJoinRequest expectJoin) {
        this.expectJoin = expectJoin;
    }


}
