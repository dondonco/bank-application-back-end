package com.dondon.projects.backend.model;

public class CheckingAccount extends Account {
    public CheckingAccount(String name) {
        super(name);
        this.setMinimumBalance(100);
        this.setPenalty(10);
        this.setTransactionCharge(1);
    }
}
