package com.mohibur.CrudDemo.Entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private long salary;

    @Column(nullable = false)
    private LocalDate dateOfBirth;
}
