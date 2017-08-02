package com.empatkepala.entity.request;

import com.empatkepala.enumeration.Department;

import java.util.Date;

/**
 * Created by Juan on 8/1/17.
 */
public class AddMppRequest {
    private long numberOfPerson;
    private String position;
    private String reason;
    private String mainResponsibility;
    private String education;
    private String experience;
    private String knowledge;
    private String employeeStatus;
    private int expectedJoin;
    private int pcAmmount;
    private String pcSpec;
    private Long idRequested;


    public long getNumberOfPerson() {
        return numberOfPerson;
    }

    public void setNumberOfPerson(long numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public Long getIdRequested() {
        return idRequested;
    }

    public void setIdRequested(Long idRequested) {
        this.idRequested = idRequested;
    }

    public static String getRequestBody() {
        return "AddMppRequest{" +
                "numberOfPerson" +
                ", position" +
                ", reason" +
                ", mainResponsibility" +
                ", education" +
                ", experience" +
                ", knowledge" +
                ", employeeStatus" +
                ", expectedJoin" +
                ", pcAmmount" +
                ", pcSpec" +
                ", idRequested" +
                '}';
    }

    public static String getHeaderContentType(){
        return "Content-Type : Application/json";
    }
}
