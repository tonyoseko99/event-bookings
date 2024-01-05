package com.tonnyseko.servlet.app.rest.api;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tonnyseko.servlet.app.bean.MpesaBeanI;
import com.tonnyseko.servlet.app.model.helpers.MpesaCallbackData;
import com.tonnyseko.servlet.app.model.helpers.PaymentRequest;

@Path("/mpesa")
public class MPesaResource extends BaseRestApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(MPesaResource.class);

    @EJB
    private MpesaBeanI mpesaBean;

    @POST
    @Path("/payment")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response initiatePayment(PaymentRequest request) {
        String phoneNumber = request.getPhoneNumber();
        double amount = request.getAmount();
        String accountReference = request.getAccountReference();
        String transactionDesc = request.getTransactionDesc();

        mpesaBean.initiateOnlinePayment(phoneNumber, amount, accountReference, transactionDesc);
        return Response.ok().build();

    }

    // get access token
    @GET
    @Path("/token")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAccessToken() {
        String accessToken = mpesaBean.getAccessToken();
        return Response.ok(accessToken).build();
    }

    @POST
    @Path("/callback")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response handleCallback(MpesaCallbackData callbackData) {
        try {
            LOGGER.info("Callback data: {}", callbackData);
            mpesaBean.handleCallback(callbackData);
            return Response.ok().build();
        } catch (Exception e) {
            LOGGER.error("Failed to handle callback", e);
            return Response.serverError().build();
        }

    }

}
