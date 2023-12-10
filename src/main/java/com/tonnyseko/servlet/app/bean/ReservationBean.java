package com.tonnyseko.servlet.app.bean;

import com.tonnyseko.servlet.app.model.entity.Event;
import com.tonnyseko.servlet.app.model.entity.Reservation;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ReservationBean extends GenericBean<Reservation> implements ReservationI {

    @PersistenceContext
    private EntityManager database;

    @Override
    public Reservation addReservation(Reservation reservation) {
        // get the event from the database
        Long eventId = reservation.getEvent().getId();
        Event event = database.find(Event.class, eventId);
        if (event == null) {
            throw new IllegalArgumentException("Event not found");
        }
        // set the event to the reservation
        reservation.setEvent(event);
        // save the reservation to the database
        database.persist(reservation);
        return reservation;
    }

}
