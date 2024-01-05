package com.tonnyseko.servlet.app.rest.api;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tonnyseko.servlet.app.bean.TicketBeanI;
import com.tonnyseko.servlet.app.model.entity.Ticket;

@Path("/tickets")
public class TicketsRestApi extends BaseRestApi {

    @EJB
    private TicketBeanI ticketBean;

    // get list of tickets {ADMIN side}
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@PathParam("id") Long id) {
        Ticket filter = new Ticket();
        filter.setId(id);

        return respond(ticketBean.list(filter.getClass()));
    }

    @Path("/ticket/{eventId}/{reservationId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("eventId") Long eventId, @PathParam("reservationId") Long reservationId) {
        return respond(ticketBean.findByEventAndReservation(eventId, reservationId));
    }

}
