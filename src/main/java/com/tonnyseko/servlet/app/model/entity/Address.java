package com.tonnyseko.servlet.app.model.entity;

import com.tonnyseko.servlet.app.helpers.HtmlCard;
import com.tonnyseko.servlet.app.helpers.HtmlForm;
import com.tonnyseko.servlet.app.helpers.HtmlFormField;

import javax.persistence.Embeddable;

@Embeddable
@HtmlForm(label = "address", url = "/reservations")
@HtmlCard(url = "./reservations?action=add")
public class Address {
    @HtmlFormField(label = "Name", name = "name")
    private String name;
    @HtmlFormField(label = "Street", name = "street")
    private String street;
    @HtmlFormField(label = "City", name = "city")
    private String city;
    @HtmlFormField(label = "State", name = "state")
    private String state;
    @HtmlFormField(label = "Zip Code", name = "zipCode")
    private String zipCode;

    public Address() {
    }

    public Address(String name, String street, String city, String state, String zipCode) {
        this.name = name;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getName() {
        return name;
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
        this.name = name;
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

    @Override
    public String toString() {
        return "Address{" +
                "name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
