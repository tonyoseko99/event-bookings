package com.tonnyseko.servlet.app.rest.api;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tonnyseko.servlet.app.bean.PaymentBeanI;
import com.tonnyseko.servlet.app.model.entity.Payment;

@Path("/payments")
public class PaymentRestApi extends BaseRestApi {
    @EJB
    private PaymentBeanI paymentsBean;

    // get list of payments {ADMIN side}
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return respond(paymentsBean.list(Payment.class));
    }

    // get payment by id
    @Path("/list/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") Long id) {
        return respond(paymentsBean.findById(Payment.class, id));
    }

    // add payment
    @Path("/add")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Payment payment) {
        paymentsBean.addOrUpdate(payment);
        return respond();
    }

    // get payments by event id and reservation id
    @Path("/list/{eventId}/{reservationId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("eventId") Long eventId, @PathParam("reservationId") Long reservationId) {
        return respond(paymentsBean.findByEventAndReservation(eventId, reservationId));
    }
}
