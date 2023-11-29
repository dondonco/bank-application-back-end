package com.dondon.projects.backend.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;

import java.util.Random;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = RegularAccount.class, name = "regular"),
        @JsonSubTypes.Type(value = CheckingAccount.class, name = "checking"),
        @JsonSubTypes.Type(value = InterestAccount.class, name = "interest")
})
public abstract class Account {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String accNumber;
    private double balance;
    private double minimumBalance;
    private double penalty;
    private double transactionCharge;
    private double interestCharge;
    private double amount;

    public Account(String name) {
        this.name = name;
        this.accNumber = generateAccountNumber();
    }

    public void withdraw() {
        double bal = this.balance - this.amount - transactionCharge;
        bal = bal < this.minimumBalance ? bal - this.penalty : bal;
        this.balance = interestCharge == 0 ? bal : bal - (bal * interestCharge);
    }

    public void deposit() {
        double bal = this.balance + this.amount - transactionCharge;
        bal = bal < this.minimumBalance ? bal - this.penalty : bal;
        this.balance = interestCharge == 0 ? bal : bal - (bal * interestCharge);
    }

    private String generateAccountNumber() {
        StringBuilder accountNumber = new StringBuilder();
        Random random = new Random(10);
        for(int i = 0; i < 16; i++) {
            accountNumber.append(random.nextInt());
        }
        return accountNumber.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public double getPenalty() {
        return penalty;
    }

    public void setPenalty(double penalty) {
        this.penalty = penalty;
    }

    public double getTransactionCharge() {
        return transactionCharge;
    }

    public void setTransactionCharge(double transactionCharge) {
        this.transactionCharge = transactionCharge;
    }

    public double getInterestCharge() {
        return interestCharge;
    }

    public void setInterestCharge(double interestCharge) {
        this.interestCharge = interestCharge;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", accNumber='" + accNumber + '\'' +
                ", balance=" + balance +
                ", minimumBalance=" + minimumBalance +
                ", penalty=" + penalty +
                ", transactionCharge=" + transactionCharge +
                ", interestCharge=" + interestCharge +
                ", amount=" + amount +
                '}';
    }
}
