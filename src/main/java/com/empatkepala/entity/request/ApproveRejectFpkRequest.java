package com.empatkepala.entity.request;

/**
 * Created by D on 31-Jul-17.
 */
public class ApproveRejectFpkRequest {
    private long idUser,idFpk;

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public long getIdFpk() {
        return idFpk;
    }

    public void setIdFpk(long idFpk) {
        this.idFpk = idFpk;
    }
}
