package com.tonnyseko.servlet.app.model.entity;

import com.tonnyseko.servlet.app.helpers.HtmlCard;
import com.tonnyseko.servlet.app.helpers.HtmlForm;

import javax.persistence.*;

@Entity
@Table(name = "reservations")
@HtmlCard(url = "./reservations?action=add")
@HtmlForm(label = "rsvp", url = "/reservations")
public class Reservation extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Embedded
    private Address address;

    public Reservation() {
    }

    public Reservation(Event event, User user, Address address) {
        this.event = event;
        this.user = user;
        this.address = address;
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
