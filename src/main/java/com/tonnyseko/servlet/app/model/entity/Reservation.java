package com.tonnyseko.servlet.app.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tonnyseko.servlet.app.helpers.FormFieldType;
import com.tonnyseko.servlet.app.helpers.HtmlCard;
import com.tonnyseko.servlet.app.helpers.HtmlForm;
import com.tonnyseko.servlet.app.helpers.HtmlFormField;
import com.tonnyseko.servlet.app.helpers.HtmlTableColumn;

import javax.persistence.*;

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

    @Column(name = "name", length = 20, nullable = false)
    @HtmlFormField(label = "name", type = FormFieldType.TEXT, required = true)
    @HtmlTableColumn(header = "Name")
    private String name;

    public Reservation() {
    }

    public Reservation(Event event, User user, String name, Address address) {
        this.event = event;
        this.user = user;
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
