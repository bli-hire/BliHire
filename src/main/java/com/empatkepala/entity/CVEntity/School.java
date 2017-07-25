package com.empatkepala.entity.CVEntity;

/**
 * Created by Ryan Bagus Susilo on 3/11/2017.
 */
public class School {
    private String schoolName;
    private String major;
    private String city;
    private String periode;
    private Double gpa;

    public School(){}
    public School(String _schoolName, String _major,String _city, String _periode,Double _gpa)
    {
        setSchoolName(_schoolName);
        setMajor(_major);
        setCity(_city);
        setPeriode(_periode);
        setGpa(_gpa);
    }
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }
}
