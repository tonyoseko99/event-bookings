package com.tonnyseko.servlet.app.bean;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.tonnyseko.servlet.app.model.entity.Ticket;

@Stateless
public class TicketBean extends GenericBean<Ticket> implements TicketBeanI {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Ticket findByEventAndReservation(Long eventId, Long reservationId) {
        try {
            return (Ticket) em.createQuery("SELECT t FROM Ticket t WHERE t.event.id = :eventId AND t.reservation.id = :reservationId")
                    .setParameter("eventId", eventId)
                    .setParameter("reservationId", reservationId)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

}
