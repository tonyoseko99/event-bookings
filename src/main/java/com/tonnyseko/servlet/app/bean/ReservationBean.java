package com.tonnyseko.servlet.app.bean;

import com.tonnyseko.servlet.app.model.entity.Reservation;
import com.tonnyseko.servlet.app.rest.api.RestResponseWrapper;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ReservationBean extends GenericBean<Reservation> implements ReservationI {

    @PersistenceContext
    private EntityManager database;

    @Override
    public Reservation findById(Long id) {
        return database.find(Reservation.class, id);
    }

    @Override
    public void delete(Class<?> klass, Long id) {
        Reservation reservation = findById(id);
        if (reservation != null) {
            database.remove(reservation);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Reservation> getReservationsByUserId(Long userId) {
        String sql = "SELECT * FROM reservations WHERE user_id = ?";
        Query query = database.createNativeQuery(sql, Reservation.class);
        query.setParameter(1, userId);
        return query.getResultList();

    }

    @Override
    public List<Reservation> getReservationsByUserIdAndEventId(Long userId, Long eventId) {
        String sql = "SELECT * FROM reservations WHERE user_id = ? AND event_id = ?";
        Query query = database.createNativeQuery(sql, Reservation.class);
        query.setParameter(1, userId);
        query.setParameter(2, eventId);
        return query.getResultList();
    }

    @Override
    public List<Object[]> getReservationsByEventId(Long eventId) {
        String sql = "SELECT * FROM reservations WHERE event_id = ?";
        Query query = database.createNativeQuery(sql);
        query.setParameter(1, eventId);
        return query.getResultList();
    }

}
