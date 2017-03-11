package com.empatkepala.entity.request;

import java.util.Date;


public class ApplicationDateRequest {
    private Date callDate;
    private Date psychoTestDate;
    private Date technicalTestDate;
    private Date interviewHRDate;
    private Date firstInterviewUserDate;
    private Date secondInterviewUserDate;
    private Date thirdInterviewUserDate;
    private Date MCU;
    private Date afterMCU;
    private Date joinDate;
    private Date noticeLetter;

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
