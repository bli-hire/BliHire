package com.empatkepala.entity;

import com.empatkepala.enumeration.Department;
import com.empatkepala.enumeration.MppStatus;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Juan on 3/11/17.
 */
@Entity
@Table(name = "mpp")
public class Mpp {

    @Id
    @GeneratedValue
    private long id;

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdDate = new DateTime();

    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime editedDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    private User editedBy;

    boolean edited = false;

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
    }

    public MppStatus getMppStatus() {
        return mppStatus;
    }

    public void setMppStatus(MppStatus mppStatus) {
        this.mppStatus = mppStatus;
    }

    private MppStatus mppStatus = MppStatus.waiting_hrd;

    public DateTime getEditedDate() {
        return editedDate;
    }

    public void setEditedDate(DateTime editedDate) {
        this.editedDate = editedDate;
    }

    public User getEditedBy() {
        return editedBy;
    }

    public void setEditedBy(User editedBy) {
        this.editedBy = editedBy;
    }

    public Collection<MppDetail> getMppDetails() {
        return mppDetail;
    }

    public void setMppDetails(Collection<MppDetail> mppDetails) {
        this.mppDetail = mppDetails;
    }

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "mpp")
    private Collection<MppDetail> mppDetail;
    private Department department;
    private boolean reject;
    private boolean accept;
    private boolean acceptHrd;
    private boolean rejectHrd;

    public boolean isAcceptHrd() {
        return acceptHrd;
    }

    public void setAcceptHrd(boolean acceptHrd) {
        this.acceptHrd = acceptHrd;
    }

    public boolean isRejectHrd() {
        return rejectHrd;
    }

    public void setRejectHrd(boolean rejectHrd) {
        this.rejectHrd = rejectHrd;
    }

    private boolean published;



    public Mpp(){

    }

//    public Mpp(String position, long numberOfPerson, String reason, String mainResponsibility,
//               String education, String experience, String knowledge, String employeeStatus, int expectedJoin,
//               int pcAmmount, String pcSpec, User requestedBy, Department department){
//        this.position = position;
//        this.numberOfPerson = numberOfPerson;
//        this.reason = reason;
//        this.mainResponsibility = mainResponsibility;
//        this.education = education;
//        this.experience = experience;
//        this.knowledge = knowledge;
//        this.employeeStatus = employeeStatus;
//        this.expectedJoin = expectedJoin;
//        this.pcAmmount = pcAmmount;
//        this.pcSpec = pcSpec;
//        this.requestedBy = requestedBy;
//        this.department = department;
//
//    }

    public Mpp(User requestedBy, Department department){
        this.requestedBy = requestedBy;
        this.department = department;

    }

    public User getAcceptedHrdBy() {
        return acceptedHrdBy;
    }

    public void setAcceptedHrdBy(User acceptedHrdBy) {
        this.acceptedHrdBy = acceptedHrdBy;
    }

    public User getRejectedHrdBy() {
        return rejectedHrdBy;
    }

    public void setRejectedHrdBy(User rejectedHrdBy) {
        this.rejectedHrdBy = rejectedHrdBy;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    private User acceptedHrdBy;


    @ManyToOne(cascade = CascadeType.MERGE)
    private User rejectedHrdBy;


    @ManyToOne(cascade = CascadeType.MERGE)
    private User requestedBy;

    @ManyToOne(cascade = CascadeType.MERGE)
    private User approvedBy;


    @ManyToOne(cascade = CascadeType.MERGE)
    private User rejectedBy;

    @ManyToOne(cascade = CascadeType.MERGE)
    private User publishedBy;

    public User getRejectedBy() {
        return rejectedBy;
    }

    public void setRejectedBy(User rejectedBy) {
        this.rejectedBy = rejectedBy;
    }

    public User getPublishedBy() {
        return publishedBy;
    }

    public void setPublishedBy(User publishedBy) {
        this.publishedBy = publishedBy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(DateTime createdDate) {
        this.createdDate = createdDate;
    }

    public User getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(User requestedBy) {
        this.requestedBy = requestedBy;
    }

    public User getApprovedBy() {
        return approvedBy;
    }

    public void
    setApprovedBy(User approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public boolean isReject() {
        return reject;
    }

    public void setReject(boolean reject) {
        this.reject = reject;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }
}
