package com.naman.upi_mesh_relay.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "vpa")
    private String vpa;

    @Column(name = "holder_name")
    private String holderName;

    @Column(name = "balance")
    private BigDecimal balance;

    // JPA requires a no-argument constructor
    public Account() {
    }

    public Account(String vpa, String holderName, BigDecimal balance) {
        this.vpa = vpa;
        this.holderName = holderName;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVpa() {
        return vpa;
    }

    public void setVpa(String vpa) {
        this.vpa = vpa;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{id=" + id + ", vpa='" + vpa + "', holderName='" + holderName
                + "', balance=" + balance + "}";
    }
}