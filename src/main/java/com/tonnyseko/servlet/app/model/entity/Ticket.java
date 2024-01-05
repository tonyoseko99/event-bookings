package com.tonnyseko.servlet.app.model.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tickets")
public class Ticket extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "reservation_id", nullable = false)
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    public Ticket() {

    }

    public Ticket(Reservation reservation, Event event) {
        this.reservation = reservation;
        this.event = event;
    }

    public Ticket(Long id, Reservation reservation, Event event) {
        setId(id);
        this.reservation = reservation;
        this.event = event;

    }

    public Reservation getReservation() {
        return reservation;
    }

    public Event getEvent() {
        return event;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Ticket [reservation=");
        builder.append(reservation);
        builder.append(", event=");
        builder.append(event);
        builder.append("]");
        return builder.toString();
    }

}
