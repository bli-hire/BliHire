package com.empatkepala.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by ARDI on 7/27/2017.
 */
public class Email {

    @org.hibernate.validator.constraints.Email
    @NotNull
    @Size(min = 1, message = "Define email destination")
    private String to;
    private String subject;
    private String text;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
