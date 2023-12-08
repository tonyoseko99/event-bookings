package com.tonnyseko.servlet.app.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RsvpDetails implements Serializable{
    
    @Column(name = "customer_name")
    private String customer_name;
    
    @Column(name = "street")
    private String street;
    
    @Column(name = "city")
    private String city;
   
    @Column(name = "state")
    private String state;
    
    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "date")
    private Date date;

    public RsvpDetails() {
    }

    public RsvpDetails(String name, String street, String city, String state, String zipCode, Date date) {
        this.customer_name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.date = date;
    }

    public String getName() {
        return customer_name;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setName(String name) {
        this.customer_name = name;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Address{" +
                "name='" + customer_name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
