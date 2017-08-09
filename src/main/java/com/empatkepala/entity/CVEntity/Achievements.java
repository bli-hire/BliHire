package com.empatkepala.entity.CVEntity;

import java.io.Serializable;

/**
 * Created by Ryan Bagus Susilo on 7/25/2017.
 */
public class Achievements implements Serializable {
    private String achievement;
    private int year;
    private String notes;

    public Achievements(){}
    public Achievements(String _achievement, int _year, String _notes) {
        this.achievement=_achievement;
        this.year=_year;
        this.notes=_notes;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getYear() {

        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAchievement() {

        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }
}
