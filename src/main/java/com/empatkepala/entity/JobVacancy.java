package com.empatkepala.entity;

import com.empatkepala.enumeration.Department;

import javax.persistence.*;

/**
 * Created by Juan on 8/4/17.
 */
@Entity
@Table(name = "job_vacancy")
public class JobVacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    Department department;
    int ammount = 0;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }


}
