package com.empatkepala.entity.request;


import com.empatkepala.enak.CVStatus;

public class AddApplicationRequest {
    private CVStatus cvStatus;
    private ApplicationScoreRequest applicationScoreRequest;
    private ApplicationDateRequest applicationDateRequest;

    public CVStatus getCvStatus() {
        return cvStatus;
    }

    public void setCvStatus(CVStatus cvStatus) {
        this.cvStatus = cvStatus;
    }

    public ApplicationScoreRequest getApplicationScoreRequest() {
        return applicationScoreRequest;
    }

    public void setApplicationScoreRequest(ApplicationScoreRequest applicationScoreRequest) {
        this.applicationScoreRequest = applicationScoreRequest;
    }

    public ApplicationDateRequest getApplicationDateRequest() {
        return applicationDateRequest;
    }

    public void setApplicationDateRequest(ApplicationDateRequest applicationDateRequest) {
        this.applicationDateRequest = applicationDateRequest;
    }
}
