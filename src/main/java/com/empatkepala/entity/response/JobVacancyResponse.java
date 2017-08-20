package com.empatkepala.entity.response;

import com.empatkepala.entity.JobVacancy;

import java.util.Collection;

/**
 * Created by Ryan Bagus Susilo on 8/8/2017.
 */
public class JobVacancyResponse {
    private String status,message;
    private Collection<JobVacancy> data;
    private String method;
    
    public JobVacancyResponse() {
    }

    public JobVacancyResponse(String status, String message, Collection<JobVacancy> data, String method) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.method = method;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Collection<JobVacancy> getData() {
        return data;
    }

    public void setData(Collection<JobVacancy> data) {
        this.data = data;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
