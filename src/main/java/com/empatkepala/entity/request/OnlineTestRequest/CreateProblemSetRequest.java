package com.empatkepala.entity.request.OnlineTestRequest;

public class CreateProblemSetRequest {

    private long numEssayEasy;
    private long numEssayMedium;
    private long numEssayHard;
    private long numMultipleChoicesEasy;
    private long numMultipleChoicesMedium;
    private long numMultipleChoicesHard;

    public long getNumEssayEasy() {
        return numEssayEasy;
    }

    public void setNumEssayEasy(long numEssayEasy) {
        this.numEssayEasy = numEssayEasy;
    }

    public long getNumEssayMedium() {
        return numEssayMedium;
    }

    public void setNumEssayMedium(long numEssayMedium) {
        this.numEssayMedium = numEssayMedium;
    }

    public long getNumEssayHard() {
        return numEssayHard;
    }

    public void setNumEssayHard(long numEssayHard) {
        this.numEssayHard = numEssayHard;
    }

    public long getNumMultipleChoicesEasy() {
        return numMultipleChoicesEasy;
    }

    public void setNumMultipleChoicesEasy(long numMultipleChoicesEasy) {
        this.numMultipleChoicesEasy = numMultipleChoicesEasy;
    }

    public long getNumMultipleChoicesMedium() {
        return numMultipleChoicesMedium;
    }

    public void setNumMultipleChoicesMedium(long numMultipleChoicesMedium) {
        this.numMultipleChoicesMedium = numMultipleChoicesMedium;
    }

    public long getNumMultipleChoicesHard() {
        return numMultipleChoicesHard;
    }

    public void setNumMultipleChoicesHard(long numMultipleChoicesHard) {
        this.numMultipleChoicesHard = numMultipleChoicesHard;
    }
}
