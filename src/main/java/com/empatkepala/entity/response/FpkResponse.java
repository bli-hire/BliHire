package com.empatkepala.entity.response;

import com.empatkepala.entity.Fpk;

import java.util.Collection;

/**
 * Created by D on 30-Jul-17.
 */
public class FpkResponse {
    private String status,message;
    private Collection<Fpk> data;
    private int totalData;

    public FpkResponse() {}

    public FpkResponse(String status,String message,Collection<Fpk> data){
        this.status = status;
        this.message = message;
        this.data = data;
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

    public Collection<Fpk> getData() {
        return data;
    }

    public void setData(Collection<Fpk> data) {
        this.data = data;
    }

    public int getTotalData(){
        return this.totalData;
    }

    public void setTotalData(int number){
        this.totalData=number;
    }

}
