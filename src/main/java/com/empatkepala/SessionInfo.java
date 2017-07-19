package com.empatkepala;

import com.empatkepala.entity.User;

/**
 * Created by Juan on 6/5/17.
 */
public class SessionInfo {
    private Long id;
    private String name;
    private String email;

    public SessionInfo(Long id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public SessionInfo(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
