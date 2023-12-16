package com.tonnyseko.servlet.app.rest.api;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tonnyseko.servlet.app.bean.AuthBeanI;
import com.tonnyseko.servlet.app.bean.UserBeanI;
import com.tonnyseko.servlet.app.model.entity.User;
import com.tonnyseko.servlet.app.model.enums.Role;

@Path("/auth")
public class AuthRestApi {
    @Inject
    private AuthBeanI authBean;

    @Inject
    private UserBeanI userBean;

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(User user) {
        try {
            userBean.register(user);
            return Response.ok().entity("Registration Successful").build();
        } catch (Exception e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(User user) {
        try {
            User authenticatedUser = authBean.authenticate(user);
            return Response.ok().entity(authenticatedUser).build();
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }
}
