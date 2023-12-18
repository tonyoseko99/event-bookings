package com.tonnyseko.servlet.app.bean;

import java.util.List;

import com.tonnyseko.servlet.app.model.entity.Reservation;

public interface ReservationI extends GenericBeanI<Reservation> {

    Reservation findById(Long id);

    List<Reservation> getReservationsByUserId(Long userId);

    List<Reservation> getReservationsByUserIdAndEventId(Long userId, Long eventId);

    // list all user details from the reservation table by event_id
    List<Object[]> getReservationsByEventId(Long eventId);
}
