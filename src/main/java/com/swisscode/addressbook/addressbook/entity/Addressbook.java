package com.swisscode.addressbook.addressbook.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Addressbook
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String identifier;
    @ManyToOne
    UserAccount userAccount;

    public Addressbook() {
    }

    public Addressbook(String identifier) {
        this.identifier = identifier;
        this.userAccount = new UserAccount();
    }

    public Addressbook(String identifier, UserAccount userAccount) {
        this.identifier = identifier;
        this.userAccount = userAccount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
}

