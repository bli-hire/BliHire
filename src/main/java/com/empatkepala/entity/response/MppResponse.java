package com.empatkepala.entity.response;

import com.empatkepala.entity.Mpp;

import java.util.Collection;

/**
 * Created by Juan on 8/1/17.
 */
public class MppResponse {
    private String status,message;
    private Collection<Mpp> data;
    private int totalData;

    public MppResponse() {}

    public MppResponse(String status,String message,Collection<Mpp> data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public MppResponse(String status,String message,Collection<Mpp> data,int totalData){
        this.status = status;
        this.message = message;
        this.data = data;
        this.totalData = totalData;
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

    public Collection<Mpp> getData() {
        return data;
    }

    public void setData(Collection<Mpp> data) {
        this.data = data;
    }

    public int getTotalData(){
        return this.totalData;
    }

    public void setTotalData(int number){
        this.totalData=number;
    }
}
