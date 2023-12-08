package com.tonnyseko.servlet.app.bean;

import com.tonnyseko.servlet.app.model.entity.Reservation;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ReservationBean extends GenericBean<Reservation> implements ReservationI {
    
    @PersistenceContext
    private EntityManager database;

    @Override
    public List<Reservation> getReservationsByCategory(String category) {
        List<Reservation> reservations = database.createQuery("SELECT r FROM Reservation r WHERE r.category = :category", Reservation.class)
                .setParameter("category", category).getResultList();
        return reservations;
    }

    @Override
    public List<Reservation> getReservationsByUser(String username) {
        List<Reservation> reservations = database.createQuery("SELECT r FROM Reservation r WHERE r.username = :username", Reservation.class)
                .setParameter("username", username).getResultList();
        return reservations;
    }

    @Override
    public List<Reservation> getReservationsByEvent(String event) {
        List<Reservation> reservations = database.createQuery("SELECT r FROM Reservation r WHERE r.event = :event", Reservation.class)
                .setParameter("event", event).getResultList();
        return reservations;
    }
}
