package com.empatkepala.entity;

import com.empatkepala.enumeration.Department;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

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

    private long numberOfPerson;
    private Department department;
    private String reason;
    private String position;
    private String mainResponsibility;
    private String education;
    private String experience;
    private String knowledge;
    private String employeeStatus;
    private int expectedJoin;
    private int pcAmmount;
    private String pcSpec;
    private boolean reject;
    private boolean accept;
    private int januaryExpect;
    private int februaryExpect;
    private int marchExpect;
    private int aprilExpect;
    private int mayExpect;
    private int juneExpect;


    private int julyExpect;
    private int augustExpect;
    private int septemberExpect;
    private int octoberExpect;
    private int novemberExpect;
    private int decemberExpect;
    private boolean published;



    public Mpp(){

    }

    public Mpp(String position, long numberOfPerson, String reason, String mainResponsibility,
               String education, String experience, String knowledge, String employeeStatus, int expectedJoin,
               int pcAmmount, String pcSpec, User requestedBy, Department department){
        this.position = position;
        this.numberOfPerson = numberOfPerson;
        this.reason = reason;
        this.mainResponsibility = mainResponsibility;
        this.education = education;
        this.experience = experience;
        this.knowledge = knowledge;
        this.employeeStatus = employeeStatus;
        this.expectedJoin = expectedJoin;
        this.pcAmmount = pcAmmount;
        this.pcSpec = pcSpec;
        this.requestedBy = requestedBy;
        this.department = department;

    }

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

    public long getNumberOfPerson() {
        return numberOfPerson;
    }

    public void setNumberOfPerson(long numberOfPerson) {
        this.numberOfPerson = numberOfPerson;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getMainResponsibility() {
        return mainResponsibility;
    }

    public void setMainResponsibility(String mainResponsibility) {
        this.mainResponsibility = mainResponsibility;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public int getExpectedJoin() {
        return expectedJoin;
    }

    public void setExpectedJoin(int expectedJoin) {
        this.expectedJoin = expectedJoin;
    }

    public int getPcAmmount() {
        return pcAmmount;
    }

    public void setPcAmmount(int pcAmmount) {
        this.pcAmmount = pcAmmount;
    }

    public String getPcSpec() {
        return pcSpec;
    }

    public void setPcSpec(String pcSpec) {
        this.pcSpec = pcSpec;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getJanuaryExpect() {
        return januaryExpect;
    }

    public void setJanuaryExpect(int januaryExpect) {
        this.januaryExpect = januaryExpect;
    }

    public int getFebruaryExpect() {
        return februaryExpect;
    }

    public void setFebruaryExpect(int februaryExpect) {
        this.februaryExpect = februaryExpect;
    }

    public int getMarchExpect() {
        return marchExpect;
    }

    public void setMarchExpect(int marchExpect) {
        this.marchExpect = marchExpect;
    }

    public int getAprilExpect() {
        return aprilExpect;
    }

    public void setAprilExpect(int aprilExpect) {
        this.aprilExpect = aprilExpect;
    }

    public int getMayExpect() {
        return mayExpect;
    }

    public void setMayExpect(int mayExpect) {
        this.mayExpect = mayExpect;
    }

    public int getJuneExpect() {
        return juneExpect;
    }

    public void setJuneExpect(int juneExpect) {
        this.juneExpect = juneExpect;
    }

    public int getJulyExpect() {
        return julyExpect;
    }

    public void setJulyExpect(int julyExpect) {
        this.julyExpect = julyExpect;
    }

    public int getAugustExpect() {
        return augustExpect;
    }

    public void setAugustExpect(int augustExpect) {
        this.augustExpect = augustExpect;
    }

    public int getSeptemberExpect() {
        return septemberExpect;
    }

    public void setSeptemberExpect(int septemberExpect) {
        this.septemberExpect = septemberExpect;
    }

    public int getOctoberExpect() {
        return octoberExpect;
    }

    public void setOctoberExpect(int octoberExpect) {
        this.octoberExpect = octoberExpect;
    }

    public int getNovemberExpect() {
        return novemberExpect;
    }

    public void setNovemberExpect(int novemberExpect) {
        this.novemberExpect = novemberExpect;
    }

    public int getDecemberExpect() {
        return decemberExpect;
    }

    public void setDecemberExpect(int decemberExpect) {
        this.decemberExpect = decemberExpect;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }
}
