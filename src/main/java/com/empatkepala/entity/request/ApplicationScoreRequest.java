package com.empatkepala.entity.request;


public class ApplicationScoreRequest {
    private int psychoTestScore;
    private int technicalTestScore;
    private int HRTestScore;
    private int firstInterviewTestScore;
    private int secondInterviewTestScore;
    private int thirdInterviewTestScore;
    private int MCUScore;

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
