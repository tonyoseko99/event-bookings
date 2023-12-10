package com.tonnyseko.servlet.app.bean;

import com.tonnyseko.servlet.app.model.entity.Reservation;

public interface ReservationI extends GenericBeanI<Reservation> {

    // add a reservation to the database using the event id
    public Reservation addReservation(Reservation reservation);
}
