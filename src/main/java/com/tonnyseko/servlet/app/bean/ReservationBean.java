package com.tonnyseko.servlet.app.bean;

import com.tonnyseko.servlet.app.model.entity.Reservation;
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

    @SuppressWarnings("unchecked")
    @Override
    public List<Reservation> getReservationsByUserIdAndEventId(Long userId, Long eventId) {
        String sql = "SELECT * FROM reservations WHERE user_id = ? AND event_id = ?";
        Query query = database.createNativeQuery(sql, Reservation.class);
        query.setParameter(1, userId);
        query.setParameter(2, eventId);
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Object[]> getReservationsByEventId(Long eventId) {
        String sql = "SELECT * FROM reservations WHERE event_id = ?";
        Query query = database.createNativeQuery(sql);
        query.setParameter(1, eventId);
        return query.getResultList();
    }

    @Override
    public Reservation findByEventAndReservation(Long eventId, Long reservationId) {
        try {
            return (Reservation) database
                    .createQuery("SELECT r FROM Reservation r WHERE r.event_id = :eventId AND r.id = :reservationId")
                    .setParameter("eventId", eventId)
                    .setParameter("reservationId", reservationId)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void deleteByEventId(Long eventId) {
        String sql = "DELETE FROM reservations WHERE event_id = ?";
        Query query = database.createNativeQuery(sql);
        query.setParameter(1, eventId);
        query.executeUpdate();

    }

    @Override
    public void deleteByUserId(Long userId) {
        String sql = "DELETE FROM reservations WHERE user_id = ?";
        Query query = database.createNativeQuery(sql);
        query.setParameter(1, userId);
        query.executeUpdate();
    }

    @Override
    public void deleteByEventIdAndUserId(Long eventId, Long userId) {
        String sql = "DELETE FROM reservations WHERE event_id = ? AND user_id = ?";
        Query query = database.createNativeQuery(sql);
        query.setParameter(1, eventId);
        query.setParameter(2, userId);
        query.executeUpdate();
    }

}
