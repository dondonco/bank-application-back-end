package com.dondon.projects.backend.model;

public class InterestAccount extends Account {
    public InterestAccount(String name) {
        super(name);
        this.setTransactionCharge(3);
    }
}
