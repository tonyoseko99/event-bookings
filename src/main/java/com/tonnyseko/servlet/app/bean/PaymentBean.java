package com.tonnyseko.servlet.app.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.tonnyseko.servlet.app.model.entity.Payment;

@Stateless
public class PaymentBean extends GenericBean<Payment> implements PaymentBeanI {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Payment findByEventAndReservation(Long eventId, Long reservationId) {
        try {
            return (Payment) em
                    .createQuery(
                            "SELECT p FROM Payment p WHERE p.event.id = :eventId AND p.reservation.id = :reservationId")
                    .setParameter("eventId", eventId)
                    .setParameter("reservationId", reservationId)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
