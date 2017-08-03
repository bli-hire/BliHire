package com.empatkepala.entity.CVEntity;

import java.io.Serializable;

/**
 * Created by Ryan Bagus Susilo on 3/11/2017.
 */
public class NonFormalCourse implements Serializable {
    private String nameOfCourse;
    private String organizer;
    private int year;
    private String notes;


    public NonFormalCourse(){}
    public NonFormalCourse(String _nameOfCourse,String _organizer, int _year,String _notes)
    {
        setNameOfCourse(_nameOfCourse);
        setOrganizer(_organizer);
        setYear(_year);
        setNotes(_notes);
    }
    public String getNameOfCourse() {
        return nameOfCourse;
    }

    public void setNameOfCourse(String nameOfCourse) {
        this.nameOfCourse = nameOfCourse;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
