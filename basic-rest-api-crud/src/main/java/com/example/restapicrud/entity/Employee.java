package com.example.restapicrud.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Emp_Table")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;
}
