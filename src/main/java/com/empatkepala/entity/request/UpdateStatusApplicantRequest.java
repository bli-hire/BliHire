package com.empatkepala.entity.request;

/**
 * Created by Juan on 8/9/17.
 */
public class UpdateStatusApplicantRequest {
    String uid;
    String statusApplicant;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getStatusApplicant() {
        return statusApplicant;
    }

    public void setStatusApplicant(String statusApplicant) {
        this.statusApplicant = statusApplicant;
    }
}
