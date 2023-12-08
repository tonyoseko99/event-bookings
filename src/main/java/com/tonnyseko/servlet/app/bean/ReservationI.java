package com.tonnyseko.servlet.app.bean;

import java.util.List;

import com.tonnyseko.servlet.app.model.entity.Reservation;

public interface ReservationI extends GenericBeanI<Reservation> {

    // Reservations per category
    List<Reservation> getReservationsByCategory(String category);

    // Reservations per user
    List<Reservation> getReservationsByUser(String username);

    // Reservations per event
    List<Reservation> getReservationsByEvent(String event);

}
