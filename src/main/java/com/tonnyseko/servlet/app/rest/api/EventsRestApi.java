package com.tonnyseko.servlet.app.rest.api;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tonnyseko.servlet.app.bean.EventInterface;
import com.tonnyseko.servlet.app.model.entity.Event;
import com.tonnyseko.servlet.app.model.enums.CategoryStatus;

@Path("/events")
public class EventsRestApi extends BaseRestApi {
    @EJB
    private EventInterface eventsBean;

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@QueryParam("id") Long id, @QueryParam("category") CategoryStatus category) {
        Event filter = new Event();
        filter.setId(id);
        filter.setCategory(category);

        return respond(eventsBean.list(filter.getClass()));
    }

    @Path("list/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEventById(@PathParam("id") Long id) {
        Event event = eventsBean.findEventById(id);
        if (event != null) {
            return respond(event);
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Path("/add")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Event event) {
        eventsBean.addOrUpdate(event);
        return respond();
    }

    @Path("/update")
    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Event event) {
        eventsBean.addOrUpdate(event);
        return respond();
    }

    @Path("/delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        eventsBean.delete(Event.class, id);
        return respond();
    }
}
