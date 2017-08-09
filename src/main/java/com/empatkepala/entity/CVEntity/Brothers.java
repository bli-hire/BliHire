package com.empatkepala.entity.CVEntity;

import java.io.Serializable;

/**
 * Created by Ryan Bagus Susilo on 3/11/2017.
 */
public class Brothers implements Serializable{

    private String brothersName;
    private String brothersBirthday;
    private String brotherLatestEducation;
    private String brotherCurrentJob;

    public Brothers(){}

    public Brothers(String _brothersName, String _brothersBirthday,String _brothersLatestEducation,String _brotherCurrentJob)
    {
        setBrothersName(_brothersName);
        setBrothersBirthday(_brothersBirthday);
        setBrotherLatestEducation(_brothersLatestEducation);
        setBrotherCurrentJob(_brotherCurrentJob);
    }


    public String getBrothersName() {
        return brothersName;
    }

    public void setBrothersName(String brothersName) {
        this.brothersName = brothersName;
    }

    public String getBrothersBirthday() {
        return brothersBirthday;
    }

    public void setBrothersBirthday(String brothersBirthday) {
        this.brothersBirthday = brothersBirthday;
    }

    public String getBrotherLatestEducation() {
        return brotherLatestEducation;
    }

    public void setBrotherLatestEducation(String brotherLatestEducation) {
        this.brotherLatestEducation = brotherLatestEducation;
    }

    public String getBrotherCurrentJob() {
        return brotherCurrentJob;
    }

    public void setBrotherCurrentJob(String brotherCurrentJob) {
        this.brotherCurrentJob = brotherCurrentJob;
    }
}
