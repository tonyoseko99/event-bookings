package com.tonnyseko.servlet.app.rest.api;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tonnyseko.servlet.app.bean.ReservationI;
import com.tonnyseko.servlet.app.model.entity.Reservation;

@Path("/reservations")
public class ReservationsRestApi extends BaseRestApi {
    @EJB
    private ReservationI reservationBean;

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return respond(reservationBean.list(Reservation.class));
    }

    @Path("/list/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReservationById(@PathParam(value = "id") Long id) {
        Reservation reservation = reservationBean.findById(id);
        if (reservation != null) {
            return respond(reservation);
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Path("/add")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Reservation reservation) {
        reservationBean.addOrUpdate(reservation);
        return respond();
    }

    @Path("/list/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteReservation(@PathParam(value = "id") Long id) {
        reservationBean.delete(Reservation.class, id);
        return respond();
    }

    // show all reservations made by a user
    @Path("/list/users/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReservationsByUserId(@PathParam(value = "id") Long id) {
        return respond(reservationBean.getReservationsByUserId(id));
    }

    // show all reservations by user_id and event_id
    @Path("/list/users/{userId}/events/{eventId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReservationsByUserIdAndEventId(@PathParam(value = "userId") Long userId,
            @PathParam(value = "eventId") Long eventId) {
        return respond(reservationBean.getReservationsByUserIdAndEventId(userId, eventId));
    }

    // unRsvp a user from an event
    @Path("/list/users/{userId}/events/{eventId}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response unRsvp(@PathParam(value = "userId") Long userId, @PathParam(value = "eventId") Long eventId) {
        reservationBean.deleteByEventIdAndUserId(userId, eventId);
        return respond();
    }

    // list all user details from the reservation table by event_id
    @Path("/list/user-details/{eventId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReservationsByEventId(@PathParam(value = "eventId") Long eventId) {
        return respond(reservationBean.getReservationsByEventId(eventId));
    }

    @Path("/ticket/{eventId}/{reservationId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("eventId") Long eventId, @PathParam("reservationId") Long reservationId) {
        return respond(reservationBean.findByEventAndReservation(eventId, reservationId));
    }

}
