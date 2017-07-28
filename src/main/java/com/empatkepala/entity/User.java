package com.empatkepala.entity;

import com.empatkepala.enumeration.Department;
import com.empatkepala.enumeration.Role;

import javax.persistence.*;

/**
 * Created by ARDI on 3/5/2017.
 */

@Entity
@Table(name="blihire_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Role role;
    private Department department;
    private String name;
    private String surname;
    private String password;
    private String email;

    public User(){}

    public User(
            Role role,
            Department department,
            String name,
            String surname,
            String password,
            String email)
    {
        this.role = role;
        this.department = department;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
