package com.empatkepala.entity.OnlineTestEntity;


import com.empatkepala.entity.CV;

import javax.persistence.*;
import java.util.List;

@Entity
public class TechnicalTest {

    @Id
    @GeneratedValue
    private long id;

    @OneToMany(mappedBy = "technicalTest", fetch = FetchType.EAGER)
    private List<Problem> problems;

    @OneToOne(mappedBy = "technicalTest", fetch = FetchType.EAGER)
    private CV cv;

    private List<String> testAnswer;

    private List<Long> scoreEachAnswer;

    // Score is stated in percent (%)
    private long score;

    private boolean isDone;

    public TechnicalTest(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Problem> getProblems() {
        return problems;
    }

    public void setProblems(List<Problem> problems) {
        this.problems = problems;
    }

    public CV getCv() {
        return cv;
    }

    public void setCv(CV cv) {
        this.cv = cv;
    }

    public List<String> getTestAnswer() {
        return testAnswer;
    }

    public void setTestAnswer(List<String> testAnswer) {
        this.testAnswer = testAnswer;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public List<Long> getScoreEachAnswer() {
        return scoreEachAnswer;
    }

    public void setScoreEachAnswer(List<Long> scoreEachAnswer) {
        this.scoreEachAnswer = scoreEachAnswer;
    }
}
