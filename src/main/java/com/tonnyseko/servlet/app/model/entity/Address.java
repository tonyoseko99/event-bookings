package com.tonnyseko.servlet.app.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(name = "email", length = 20)
    private String email;

    @Column(name = "phone", length = 10)
    private String phone;

    @Column(name = "city")
    private String city;
    
    @Column(name = "zip_code")
    private String zipCode;

    public Address() {
    }

    public Address(String email, String phone, String city, String zipCode) {
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public Address setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Address setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Address setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }


}
