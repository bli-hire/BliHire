package com.empatkepala.entity;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by Juan on 3/11/17.
 */
@Entity
@Table(name = "mpp")
public class Mpp {

    @Id
    @GeneratedValue
    private long id;

    private long numberOfPerson;
    private String reason;
    private String mainResponsibility;
    private String education;
    private String experience;
    private String knowledge;
    private String employeeStatus;
    private int expectedJoin;
    private int pcAmmount;
    private String pcSpec;

    @ManyToOne(cascade = CascadeType.MERGE)
    private User requestedBy;





}
