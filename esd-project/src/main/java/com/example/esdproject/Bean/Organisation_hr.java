package com.example.esdproject.Bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "organisation_hr")
public class Organisation_hr {

    @Id
    private Integer id;

    @Column(nullable = false)
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String email;

}
