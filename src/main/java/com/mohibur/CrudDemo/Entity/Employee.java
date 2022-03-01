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

    @Column
    private String name;

    @Column
    private String department;

    @Column
    private String address;

    @Column
    private long salary;

    @Column
    private LocalDate dateOfBirth;
}
