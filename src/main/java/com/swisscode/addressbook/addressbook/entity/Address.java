package com.swisscode.addressbook.addressbook.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Entity
public class Address
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String firstName;
    String lastName;
    String phoneNumber;
    String postalcode;
    String address;
    String country;
    @ManyToOne
    Addressbook addressbook;

    public Address() {
    }

    public Address(String firstName, String lastName, String phoneNumber, String postalcode, String address, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.postalcode = postalcode;
        this.address = address;
        this.country = country;
        this.addressbook = new Addressbook();
    }

    public Address(Long id, String firstName, String lastName, String phoneNumber, String postalcode, String address, String country) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.postalcode = postalcode;
        this.address = address;
        this.country = country;
        this.addressbook = new Addressbook();
    }

    public Address(String firstName, String lastName, String phoneNumber, String postalcode, String address, String country, Addressbook addressbook) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.postalcode = postalcode;
        this.address = address;
        this.country = country;
        this.addressbook = addressbook;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Addressbook getAddressbook() {
        return addressbook;
    }

    public void setAddressbook(Addressbook addressbook) {
        this.addressbook = addressbook;
    }
}
