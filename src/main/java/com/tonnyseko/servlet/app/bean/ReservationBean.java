package com.tonnyseko.servlet.app.bean;

import com.tonnyseko.servlet.app.model.entity.Reservation;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ReservationBean extends GenericBean<Reservation> implements ReservationI {
    @PersistenceContext
    private EntityManager database;
    
    @Override
    public void addOrUpdate(Reservation reservation) {
        if (reservation.getId() != null) {
            Reservation existingReservation = database.find(Reservation.class, reservation.getId());
            if (existingReservation != null) {
                // update(reservation);
                existingReservation.setEvent(reservation.getEvent());
                existingReservation.setName(reservation.getName());
                existingReservation.setAddress(reservation.getAddress());
                existingReservation.setUser(reservation.getUser());
            } else {
                database.merge(reservation);
            }
        } else {
            database.merge(reservation);
        }
    }

}
