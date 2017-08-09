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
    @OneToOne
    private CV cv;




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
}