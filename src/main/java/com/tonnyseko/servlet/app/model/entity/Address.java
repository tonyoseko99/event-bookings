package com.tonnyseko.servlet.app.model.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(name = "email", length = 20, nullable = false)
    private String email;

    @Column(name = "phone", length = 10, nullable = false)
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

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    
}
