package com.empatkepala.entity.OnlineTestEntity;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Problem {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private TechnicalTest technicalTest;

    private long maxScore;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TechnicalTest getTechnicalTest() {
        return technicalTest;
    }

    public void setTechnicalTest(TechnicalTest technicalTest) {
        this.technicalTest = technicalTest;
    }

    public long getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(long maxScore) {
        this.maxScore = maxScore;
    }
}
