package com.empatkepala.entity.response;

import com.empatkepala.entity.CV;


import java.util.Collection;

/**
 * Created by Ryan Bagus Susilo on 8/4/2017.
 */
public class CVResponse {
    private String status,message;
    private Collection<CV> data;
    private int totalData;
    private String requestHeader;
    private String requestBody;
    private String method;

    public CVResponse() {
    }

    public CVResponse(String status, String message, Collection<CV> data, int totalData, String requestHeader, String requestBody, String method) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.totalData = totalData;
        this.requestHeader = requestHeader;
        this.requestBody = requestBody;
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

    public Collection<CV> getData() {
        return data;
    }

    public void setData(Collection<CV> data) {
        this.data = data;
    }

    public int getTotalData() {
        return totalData;
    }

    public void setTotalData(int totalData) {
        this.totalData = totalData;
    }

    public String getRequestHeader() {
        return requestHeader;
    }

    public void setRequestHeader(String requestHeader) {
        this.requestHeader = requestHeader;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
