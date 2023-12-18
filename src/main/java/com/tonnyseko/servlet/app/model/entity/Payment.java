package com.tonnyseko.servlet.app.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "payments", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "reservation_id", "user_id" })
})
public class Payment extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(name = "amount")
    private double amount;

    @Column(name = "payment_date")
    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    // fetch ticket price from event
    public double getTicketPrice() {
        return event.getTicketPrice();
    }

    public Payment() {
    }

    public Payment(Long id, User user, Reservation reservation, double amount, Date paymentDate) {
        setId(id);
        this.user = user;
        this.reservation = reservation;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public User getUser() {
        return user;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
        this.amount = event.getTicketPrice();
    }

    public double getAmount() {
        return amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public boolean isNew() {
        return getId() == null;
    }

}
