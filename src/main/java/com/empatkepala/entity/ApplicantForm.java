package com.empatkepala.entity;

import com.empatkepala.enak.CVStatus;
import com.sun.istack.internal.Nullable;

import javax.persistence.*;
import java.util.Date;


@Entity
public class ApplicantForm {

    @Id
    @GeneratedValue
    private long id;

    @Nullable
    private CVStatus cvStatus;

    @OneToOne(cascade = CascadeType.ALL)
    private ApplicantDate applicantDate;

    @OneToOne(cascade = CascadeType.ALL)
    private ApplicantScore applicantScore;

    @Nullable
    private String addedNote;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public CVStatus getCvStatus() {
        return cvStatus;
    }

    public void setCvStatus(CVStatus cvStatus) {
        this.cvStatus = cvStatus;
    }

    public ApplicantDate getApplicantDate() {
        return applicantDate;
    }

    public void setApplicantDate(ApplicantDate applicantDate) {
        this.applicantDate = applicantDate;
    }

    public ApplicantScore getApplicantScore() {
        return applicantScore;
    }

    public void setApplicantScore(ApplicantScore applicantScore) {
        this.applicantScore = applicantScore;
    }

    public String getAddedNote() {
        return addedNote;
    }

    public void setAddedNote(String addedNote) {
        this.addedNote = addedNote;
    }
//    @OneToOne
//    @PrimaryKeyJoinColumn
//    private CV cv;



}
