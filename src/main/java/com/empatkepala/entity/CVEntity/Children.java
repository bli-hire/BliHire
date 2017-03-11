package com.empatkepala.entity.CVEntity;

/**
 * Created by Ryan Bagus Susilo on 3/11/2017.
 */
public class Children {
    private String childrenName;
    private String childrenBirthday;
    private String childrenLatestEducation;
    private String childrenCurrentJob;

    public Children(){}
    public Children(String _childrenName,String _childrenBirthday,String _childrenLatestEducation,String _childrenCurrentJob)
    {
        setChildrenName(_childrenName);
        setChildrenBirthday(_childrenBirthday);
        setChildrenLatestEducation(_childrenLatestEducation);
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

    public String getChildrenLatestEducation() {
        return childrenLatestEducation;
    }

    public void setChildrenLatestEducation(String cshildrenLatestEducation) {
        this.childrenLatestEducation = childrenLatestEducation;
    }

    public String getChildrenCurrentJob() {
        return childrenCurrentJob;
    }

    public void setChildrenCurrentJob(String childrenCurrentJob) {
        this.childrenCurrentJob = childrenCurrentJob;
    }
}
