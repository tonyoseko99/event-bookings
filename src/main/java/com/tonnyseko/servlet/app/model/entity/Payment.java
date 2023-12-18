package com.tonnyseko.servlet.app.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "payments")
public class Payment extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @Column(name = "amount")
    private double amount;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    public Payment() {
    }

    public Payment(Long id, User user, Reservation reservation, double amount, LocalDate paymentDate) {
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

    public double getAmount() {
        return amount;
    }

    public LocalDate getPaymentDate() {
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

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public boolean isNew() {
        return getId() == null;
    }

    
    
}
