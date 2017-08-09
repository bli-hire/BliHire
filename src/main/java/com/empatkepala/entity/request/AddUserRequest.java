package com.empatkepala.entity.request;


import com.empatkepala.enumeration.Department;
import com.empatkepala.enumeration.Role;

/**
 * Created by ARDI on 3/5/2017.
 */
public class AddUserRequest {

    private String name;
    private String surname;
    private String password;
    private String email;
    private Role role;
    private Department department;

    public AddUserRequest(){

    }

    public AddUserRequest(String name, String surname, String password, String email, Role role, Department department) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.role = role;
        this.department = department;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
