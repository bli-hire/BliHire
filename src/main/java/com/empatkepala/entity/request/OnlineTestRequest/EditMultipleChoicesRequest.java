package com.empatkepala.entity.request.OnlineTestRequest;

public class EditMultipleChoicesRequest {

    private String problem;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String realAnswer;


    private String difficulty;
    private boolean canBeGenerated;

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getRealAnswer() {
        return realAnswer;
    }

    public void setRealAnswer(String realAnswer) {
        this.realAnswer = realAnswer;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isCanBeGenerated() {
        return canBeGenerated;
    }

    public void setCanBeGenerated(boolean canBeGenerated) {
        this.canBeGenerated = canBeGenerated;
    }
}
