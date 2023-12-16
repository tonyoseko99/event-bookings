package com.tonnyseko.servlet.app.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tonnyseko.servlet.app.helpers.FormFieldType;
import com.tonnyseko.servlet.app.helpers.HtmlCard;
import com.tonnyseko.servlet.app.helpers.HtmlForm;
import com.tonnyseko.servlet.app.helpers.HtmlFormField;
import com.tonnyseko.servlet.app.helpers.HtmlTableColumn;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "reservations", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "event_id", "user_id" })
})
@HtmlCard(url = "./reservations?action=rsvp&id=")
@HtmlForm(label = "rsvp", url = "./reservations")
public class Reservation extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonProperty("event_id")
    @HtmlTableColumn(header = "Event")
    private Event event;

    @ManyToOne
    @JsonProperty("user_id")
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "code", length = 20, nullable = false)
    @HtmlFormField(label = "code", type = FormFieldType.TEXT, required = true)
    @HtmlTableColumn(header = "Code")
    private String code = UUID.randomUUID().toString();

    @Column(name = "name", length = 20, nullable = false)
    @HtmlFormField(label = "name", type = FormFieldType.TEXT, required = true)
    @HtmlTableColumn(header = "Name")
    private String name;

    @Column(name = "email", length = 20)
    private String email;

    @Column(name = "phone", length = 10)
    private String phone;

    @Column(name = "city")
    private String city;

    @Column(name = "zip_code")
    private String zipCode;

    public Reservation() {
    }

    public Reservation(Long id, Event event, User user, String code, String name, String email, String phone,
            String city,
            String zipCode) {
        setId(id);
        this.event = event;
        this.user = user;
        this.code = code;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.zipCode = zipCode;

    }

    public Long getId() {
        return super.getId();
    }

    // set id
    public void setId(Long id) {
        super.setId(id);
    }

    public String getCode() {
        return code;
    }

    public void setCodee(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmaill(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhonee(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCityy(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCodee(String zipCode) {
        this.zipCode = zipCode;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
