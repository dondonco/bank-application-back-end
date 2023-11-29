package com.dondon.projects.backend.model;

public class RegularAccount extends Account {
    public RegularAccount(String name) {
        super(name);
        this.setMinimumBalance(500);
        this.setPenalty(10);
    }
}
