package com.empatkepala.entity.response;

import com.empatkepala.entity.Fpk;

import java.util.Collection;

/**
 * Created by D on 30-Jul-17.
 */
public class FpkResponse {
    private String status,message,requestHeader,requestBody,method;
    private Collection<Fpk> data;
    private int totalData;

    public FpkResponse() {}

    public FpkResponse(String status,String message,Collection<Fpk> data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public FpkResponse(String status,String message,Collection<Fpk> data,int totalData){
        this.status = status;
        this.message = message;
        this.data = data;
        this.totalData = totalData;
    }

    public FpkResponse(String status,String message,Collection<Fpk> data,int totalData,
                       String method,String requestHeader, String requestBody){
        this.status = status;
        this.message = message;
        this.data = data;
        this.totalData = totalData;
        this.method = method;
        this.requestBody = requestBody;
        this.requestHeader = requestHeader;
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
