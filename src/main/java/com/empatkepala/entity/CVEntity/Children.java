package com.empatkepala.entity.CVEntity;

import java.io.Serializable;

/**
 * Created by Ryan Bagus Susilo on 3/11/2017.
 */
public class Children implements Serializable {
    private String childrenName;
    private String childrenBirthday;
    private String childrenCurrentJob;
    private String chilLatestEdu;

    public Children(){}
    public Children(String _childrenName,String _childrenBirthday,String _childrenLatestEducation,String _childrenCurrentJob)
    {
        setChildrenName(_childrenName);
        setChilLatestEdu(_childrenLatestEducation);
        setChildrenBirthday(_childrenBirthday);
        setChildrenCurrentJob(_childrenCurrentJob);
    }

    public String getChildrenName() {
        return childrenName;
    }

    public void setChildrenName(String childrenName) {
        this.childrenName = childrenName;
    }

    public String getChildrenBirthday() {
        return childrenBirthday;
    }

    public void setChildrenBirthday(String childrenBirthday) {
        this.childrenBirthday = childrenBirthday;
    }

    public String getChilLatestEdu() {
        return chilLatestEdu;
    }

    public void setChilLatestEdu(String chilLatestEdu) {
        this.chilLatestEdu = chilLatestEdu;
    }
    public String getChildrenCurrentJob() {
        return childrenCurrentJob;
    }

    public void setChildrenCurrentJob(String childrenCurrentJob) {
        this.childrenCurrentJob = childrenCurrentJob;
    }
}
