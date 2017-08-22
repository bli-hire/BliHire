package com.empatkepala.entity.request;

/**
 * Created by Juan on 8/2/17.
 */
public class ApproveRejectMppRequest {
    private long idUser, idMpp;

    public ApproveRejectMppRequest(long idUser, long idMpp) {
        this.idUser = idUser;
        this.idMpp = idMpp;
    }

    public ApproveRejectMppRequest() {
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getIdMpp() {
        return idMpp;
    }

    public void setIdMpp(long idMpp) {
        this.idMpp = idMpp;
    }
}
