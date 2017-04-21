package com.empatkepala.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Juan on 3/11/17.
 */
@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue
    private long id;
    private String roleName;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
