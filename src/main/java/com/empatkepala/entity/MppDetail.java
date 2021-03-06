package com.empatkepala.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by Juan on 8/4/17.
 */

@Entity
@Table(name = "mpp_detail")
public class MppDetail {

    @Id
    @GeneratedValue
    private long id;

    private String position;
    private int numberOfPerson = 0;
    private String reason;
    private String mainResponsibility;
    private String education;
    private String experience;
    private String knowledge;
    private String employeeStatus;
    private int expectedJoin = 0;
    private int pcAmmount;
    private String pcSpec;

    @ManyToOne(cascade = CascadeType.MERGE)
    private Mpp mpp;

    public MppDetail(){

    }
    public MppDetail(String position, int numberOfPerson, String reason, String mainResponsibility, String education, String experience, String knowledge, String employeeStatus, int expectedJoin, int pcAmmount, String pcSpec, Mpp mpp) {
        this.position = position;
        this.reason = reason;
        this.mainResponsibility = mainResponsibility;
        this.education = education;
        this.experience = experience;
        this.knowledge = knowledge;
        this.employeeStatus = employeeStatus;
        this.pcAmmount = pcAmmount;
        this.pcSpec = pcSpec;
        this.mpp = mpp;
    }

    private int januaryExpect;
    private int februaryExpect;
    private int marchExpect;
    private int aprilExpect;
    private int mayExpect;
    private int juneExpect;


    private int julyExpect;
    private int augustExpect;
    private int septemberExpect;
    private int octoberExpect;
    private int novemberExpect;
    private int decemberExpect;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    @JsonIgnore
    public Mpp getMpp() {
        return mpp;
    }

    public void setMpp(Mpp mpp) {
        this.mpp = mpp;
    }

    public int getJanuaryExpect() {
        return januaryExpect;
    }

    public void setJanuaryExpect(int januaryExpect) {
        this.januaryExpect = januaryExpect;
    }

    public int getFebruaryExpect() {
        return februaryExpect;
    }

    public void setFebruaryExpect(int februaryExpect) {
        this.februaryExpect = februaryExpect;
    }

    public int getMarchExpect() {
        return marchExpect;
    }

    public void setMarchExpect(int marchExpect) {
        this.marchExpect = marchExpect;
    }

    public int getAprilExpect() {
        return aprilExpect;
    }

    public void setAprilExpect(int aprilExpect) {
        this.aprilExpect = aprilExpect;
    }

    public int getMayExpect() {
        return mayExpect;
    }

    public void setMayExpect(int mayExpect) {
        this.mayExpect = mayExpect;
    }

    public int getJuneExpect() {
        return juneExpect;
    }

    public void setJuneExpect(int juneExpect) {
        this.juneExpect = juneExpect;
    }

    public int getJulyExpect() {
        return julyExpect;
    }

    public void setJulyExpect(int julyExpect) {
        this.julyExpect = julyExpect;
    }

    public int getAugustExpect() {
        return augustExpect;
    }

    public void setAugustExpect(int augustExpect) {
        this.augustExpect = augustExpect;
    }

    public int getSeptemberExpect() {
        return septemberExpect;
    }

    public void setSeptemberExpect(int septemberExpect) {
        this.septemberExpect = septemberExpect;
    }

    public int getOctoberExpect() {
        return octoberExpect;
    }

    public void setOctoberExpect(int octoberExpect) {
        this.octoberExpect = octoberExpect;
    }

    public int getNovemberExpect() {
        return novemberExpect;
    }

    public void setNovemberExpect(int novemberExpect) {
        this.novemberExpect = novemberExpect;
    }

    public int getDecemberExpect() {
        return decemberExpect;
    }

    public void setDecemberExpect(int decemberExpect) {
        this.decemberExpect = decemberExpect;
    }


    public void setExpectedJoinAndNumberOfPersonTotal(){
        this.expectedJoin += this.januaryExpect +  this.februaryExpect + this.marchExpect
                + this.aprilExpect + this.mayExpect + this.juneExpect + this.julyExpect
                + this.augustExpect + this.septemberExpect + this.octoberExpect + this.novemberExpect
                + this.decemberExpect;

        this.numberOfPerson += this.januaryExpect +  this.februaryExpect + this.marchExpect
                + this.aprilExpect + this.mayExpect + this.juneExpect + this.julyExpect
                + this.augustExpect + this.septemberExpect + this.octoberExpect + this.novemberExpect
                + this.decemberExpect;
    }
}
