package com.dondon.projects.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private Integer id;

}
