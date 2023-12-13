package com.tonnyseko.servlet.app.rest.api;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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

    @Path("/add")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Reservation reservation) {
        reservationBean.addOrUpdate(reservation);
        return respond();
    }

}
