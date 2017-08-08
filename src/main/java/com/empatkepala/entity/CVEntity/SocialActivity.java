package com.empatkepala.entity.CVEntity;

import java.io.Serializable;

/**
 * Created by Ryan Bagus Susilo on 7/25/2017.
 */
public class SocialActivity implements Serializable {
    private String nameOrganization;
    private String fieldOfOrganization;
    private String attendancePeriod;
    private String notes;

    public SocialActivity(){}
    public SocialActivity(String _nameOfOrganization, String _fieldOfOrganization, String attendancePeriod, String _notes){
        this.nameOrganization=_nameOfOrganization;
        this.fieldOfOrganization=_fieldOfOrganization;
        this.attendancePeriod=attendancePeriod;
        this.notes=_notes;
    }

    public String getNameOrganization() {
        return nameOrganization;
    }

    public void setNameOrganization(String nameOrganization) {
        this.nameOrganization = nameOrganization;
    }
    public String getFieldOfOrganization() {
        return fieldOfOrganization;
    }

    public void setFieldOfOrganization(String fieldOfOrganization) {
        this.fieldOfOrganization = fieldOfOrganization;
    }
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getAttendancePeriod() {
        return attendancePeriod;
    }

    public void setAttendancePeriod(String attendancePeriod) {
        this.attendancePeriod = attendancePeriod;
    }

}
