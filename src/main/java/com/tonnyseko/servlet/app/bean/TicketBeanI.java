package com.tonnyseko.servlet.app.bean;

import com.tonnyseko.servlet.app.model.entity.Ticket;

public interface TicketBeanI extends GenericBeanI<Ticket>{

    Ticket findByEventAndReservation(Long eventId, Long reservationId);
    
}
