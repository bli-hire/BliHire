package com.empatkepala.entity.CVEntity;

import java.io.Serializable;

/**
 * Created by Ryan Bagus Susilo on 3/11/2017.
 */
public class WorkExperience implements Serializable {
    private String companyName;
    private String companyField;
    private String position;
    private String period;
    private String jobDescription;
    private String reasonToLeave;
    private String referenceName;
    private String referencePosition;
    private String referencePhoneNumber;
    private String organizationalChart;

    public WorkExperience(){}
    public WorkExperience(String _companyName,String _companyField, String _position,String _period, String _jobDescription,String _reasonToLeave,String _referenceName,String _referencePosition,String _referencePhoneNumber, String _organizationalChart){
        setCompanyName(_companyName);
        setCompanyField(_companyField);
        setPosition(_position);
        setPeriod(_period);
        setJobDescription(_jobDescription);
        setReasonToLeave(_reasonToLeave);
        setReferenceName(_referenceName);
        setReferencePosition(_referencePosition);
        setReferencePhoneNumber(_referencePhoneNumber);
        setOrganizationalChart(_organizationalChart);
    }
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyField() {
        return companyField;
    }

    public void setCompanyField(String companyField) {
        this.companyField = companyField;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getReasonToLeave() {
        return reasonToLeave;
    }

    public void setReasonToLeave(String reasonToLeave) {
        this.reasonToLeave = reasonToLeave;
    }

    public String getReferenceName() {
        return referenceName;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    public String getReferencePosition() {
        return referencePosition;
    }

    public void setReferencePosition(String referencePosition) {
        this.referencePosition = referencePosition;
    }

    public String getReferencePhoneNumber() {
        return referencePhoneNumber;
    }

    public void setReferencePhoneNumber(String referencePhoneNumber) {
        this.referencePhoneNumber = referencePhoneNumber;
    }

    public String getOrganizationalChart() {
        return organizationalChart;
    }

    public void setOrganizationalChart(String organizationalChart) {
        this.organizationalChart = organizationalChart;
    }
}
