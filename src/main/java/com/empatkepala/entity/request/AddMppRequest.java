package com.empatkepala.entity.request;

import java.util.Collection;

/**
 * Created by Juan on 8/1/17.
 */
public class AddMppRequest {
    private Long idRequested;
    private Collection<MppDetailRequest> mppDetails;

    public Collection<MppDetailRequest> getMppDetails() {
        return mppDetails;
    }

    public void setMppDetails(Collection<MppDetailRequest> mppDetails) {
        this.mppDetails = mppDetails;
    }



    public Long getIdRequested() {
        return idRequested;
    }

    public void setIdRequested(Long idRequested) {
        this.idRequested = idRequested;
    }

    public static String getRequestBody() {
        return "AddMppRequest{" +
                "numberOfPerson" +
                ", position" +
                ", reason" +
                ", mainResponsibility" +
                ", education" +
                ", experience" +
                ", knowledge" +
                ", employeeStatus" +
                ", expectedJoin" +
                ", pcAmmount" +
                ", pcSpec" +
                ", idRequested" +
                '}';
    }

    public static String getHeaderContentType(){
        return "Content-Type : Application/json";
    }

}
