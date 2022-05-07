package com.ad.StdManager.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Students")
public class Student {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name = "First_Name", nullable = false)
    private String Fname;

    @Column(name = "Last_Name", nullable = false)
    private String Lname;
}
