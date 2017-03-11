package com.empatkepala.entity;

import com.sun.istack.internal.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ApplicantScore {

    @Id
    @GeneratedValue
    private long id;

    @Nullable
    private int psychoTestScore;
    @Nullable
    private int technicalTestScore;
    @Nullable
    private int HRTestScore;
    @Nullable
    private int firstInterviewTestScore;
    @Nullable
    private int secondInterviewTestScore;
    @Nullable
    private int thirdInterviewTestScore;
    @Nullable
    private int MCUScore;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPsychoTestScore() {
        return psychoTestScore;
    }

    public void setPsychoTestScore(int psychoTestScore) {
        this.psychoTestScore = psychoTestScore;
    }

    public int getTechnicalTestScore() {
        return technicalTestScore;
    }

    public void setTechnicalTestScore(int technicalTestScore) {
        this.technicalTestScore = technicalTestScore;
    }

    public int getHRTestScore() {
        return HRTestScore;
    }

    public void setHRTestScore(int HRTestScore) {
        this.HRTestScore = HRTestScore;
    }

    public int getFirstInterviewTestScore() {
        return firstInterviewTestScore;
    }

    public void setFirstInterviewTestScore(int firstInterviewTestScore) {
        this.firstInterviewTestScore = firstInterviewTestScore;
    }

    public int getSecondInterviewTestScore() {
        return secondInterviewTestScore;
    }

    public void setSecondInterviewTestScore(int secondInterviewTestScore) {
        this.secondInterviewTestScore = secondInterviewTestScore;
    }

    public int getThirdInterviewTestScore() {
        return thirdInterviewTestScore;
    }

    public void setThirdInterviewTestScore(int thirdInterviewTestScore) {
        this.thirdInterviewTestScore = thirdInterviewTestScore;
    }

    public int getMCUScore() {
        return MCUScore;
    }

    public void setMCUScore(int MCUScore) {
        this.MCUScore = MCUScore;
    }



}
