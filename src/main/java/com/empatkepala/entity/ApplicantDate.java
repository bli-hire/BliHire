package com.empatkepala.entity;

import com.sun.istack.internal.Nullable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class ApplicantDate {
    @Id
    @GeneratedValue
    private long id;

    private Date createdDate = new Date();
    @Nullable
    private Date callDate;
    @Nullable
    private Date psychoTestDate;
    @Nullable
    private Date technicalTestDate;
    @Nullable
    private Date interviewHRDate;
    @Nullable
    private Date firstInterviewUserDate;
    @Nullable
    private Date secondInterviewUserDate;
    @Nullable
    private Date thirdInterviewUserDate;
    @Nullable
    private Date MCU;
    @Nullable
    private Date afterMCU;
    @Nullable
    private Date joinDate;
    @Nullable
    private Date noticeLetter;

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

    public Date getCallDate() {
        return callDate;
    }

    public void setCallDate(Date callDate) {
        this.callDate = callDate;
    }

    public Date getPsychoTestDate() {
        return psychoTestDate;
    }

    public void setPsychoTestDate(Date psychoTestDate) {
        this.psychoTestDate = psychoTestDate;
    }

    public Date getTechnicalTestDate() {
        return technicalTestDate;
    }

    public void setTechnicalTestDate(Date technicalTestDate) {
        this.technicalTestDate = technicalTestDate;
    }

    public Date getInterviewHRDate() {
        return interviewHRDate;
    }

    public void setInterviewHRDate(Date interviewHRDate) {
        this.interviewHRDate = interviewHRDate;
    }

    public Date getFirstInterviewUserDate() {
        return firstInterviewUserDate;
    }

    public void setFirstInterviewUserDate(Date firstInterviewUserDate) {
        this.firstInterviewUserDate = firstInterviewUserDate;
    }

    public Date getSecondInterviewUserDate() {
        return secondInterviewUserDate;
    }

    public void setSecondInterviewUserDate(Date secondInterviewUserDate) {
        this.secondInterviewUserDate = secondInterviewUserDate;
    }

    public Date getThirdInterviewUserDate() {
        return thirdInterviewUserDate;
    }

    public void setThirdInterviewUserDate(Date thirdInterviewUserDate) {
        this.thirdInterviewUserDate = thirdInterviewUserDate;
    }

    public Date getMCU() {
        return MCU;
    }

    public void setMCU(Date MCU) {
        this.MCU = MCU;
    }

    public Date getAfterMCU() {
        return afterMCU;
    }

    public void setAfterMCU(Date afterMCU) {
        this.afterMCU = afterMCU;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Date getNoticeLetter() {
        return noticeLetter;
    }

    public void setNoticeLetter(Date noticeLetter) {
        this.noticeLetter = noticeLetter;
    }
}
