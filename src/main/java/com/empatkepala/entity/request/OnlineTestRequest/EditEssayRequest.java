package com.empatkepala.entity.request.OnlineTestRequest;

public class EditEssayRequest {

    private String problem;
    private String answer;

    private String difficulty;
    private boolean canBeGenerated;

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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
