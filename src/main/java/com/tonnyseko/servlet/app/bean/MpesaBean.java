package com.tonnyseko.servlet.app.bean;

import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tonnyseko.servlet.app.model.entity.MpesaTransaction;
import com.tonnyseko.servlet.app.model.entity.Payment;
import com.tonnyseko.servlet.app.model.helpers.MpesaCallbackData;

import jakarta.json.JsonException;

@Stateless
public class MpesaBean implements MpesaBeanI {

    // logger
    private static final Logger LOGGER = LoggerFactory.getLogger(MpesaBean.class);

    @PersistenceContext
    private EntityManager database;

    private static final String MPESA_API_URL = "https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials";
    private static final String MPESA_CONSUMER_KEY = "F3meL3xqDbRXZD0iVYrck1ICUKDGr6DS";
    private static final String MPESA_CONSUMER_SECRET = "pjIS600iTVGRGL4v";

    public String getAccessToken() {
        Client client = ClientBuilder.newClient();
        String auth = Base64.getEncoder().encodeToString((MPESA_CONSUMER_KEY + ":" + MPESA_CONSUMER_SECRET).getBytes());

        Response response = client.target(MPESA_API_URL)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header(HttpHeaders.AUTHORIZATION, "Basic " + auth)
                .get();

        if (response.getStatus() == 200) {
            // Parse the JSON response to extract access_token
            String jsonResponse = response.readEntity(String.class);
            try {
                JsonReader reader = Json.createReader(new StringReader(jsonResponse));
                JsonObject jsonObject = reader.readObject();
                reader.close();

                String accessToken = jsonObject.getString("access_token");
                return accessToken;
            } catch (JsonException e) {
                LOGGER.error("Failed to parse JSON response. Response: {}", jsonResponse);
                throw new RuntimeException("Failed to parse JSON response");
            }
        } else {
            LOGGER.error("Failed to get access token. Response: {}", response.readEntity(String.class));
            throw new RuntimeException("Failed to get access token: " + response.getStatus());
        }
    }

    public String initiateOnlinePayment(String phoneNumber, double amount, String accountReference,
            String transactionDesc) {
        try {
            // Obtain access token
            String accessToken = getAccessToken();
            LOGGER.info("Access token: {}", accessToken);

            // M-Pesa API endpoint and credentials
            String lipaNaMpesaUrl = "https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest";
            String businessShortCode = "174379";
            String passKey = "bfb279f9aa9bdbcf158e97dd71a467cd2e0c893059b10f78e6b72ada1ed2c919";
            String callBackUrl = "https://7e2c-102-135-169-115.ngrok-free.app/bookings/rest/mpesa/callback";

            // Generate timestamp
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

            // Generate password
            String password = Base64.getEncoder().encodeToString((businessShortCode + passKey + timestamp).getBytes());

            // Build request body
            String requestBody = String.format(
                    "{\"BusinessShortCode\": \"%s\"," +
                            "\"Password\": \"%s\"," +
                            "\"Timestamp\": \"%s\"," +
                            "\"TransactionType\": \"CustomerPayBillOnline\"," +
                            "\"Amount\": %.2f," +
                            "\"PartyA\": \"%s\"," +
                            "\"PartyB\": \"%s\"," +
                            "\"PhoneNumber\": \"%s\"," +
                            "\"CallBackURL\": \"%s\"," +
                            "\"AccountReference\": \"%s\"," +
                            "\"TransactionDesc\": \"%s\"}",
                    businessShortCode, password, timestamp, amount, phoneNumber,
                    businessShortCode, phoneNumber, callBackUrl, accountReference, transactionDesc);

            // Send POST request
            Response response = ClientBuilder.newClient()
                    .target(lipaNaMpesaUrl)
                    .request(MediaType.APPLICATION_JSON)
                    .header(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken)
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                    .post(Entity.json(requestBody));

            // Handle the response
            if (response.getStatus() == 200) {
                String jsonResponse = response.readEntity(String.class);
                LOGGER.info("Initiated payment. Response: {}", jsonResponse);
                return jsonResponse;
            } else {
                String errorResponse = response.readEntity(String.class);
                LOGGER.error("Failed to initiate payment. Response: {}", errorResponse);
                throw new RuntimeException("Failed to initiate payment: " + response.getStatus());
            }

        } catch (Exception e) {
            LOGGER.error("Error during payment initiation", e);
            throw new RuntimeException("Error during payment initiation", e);
        }
    }

    @Override
    public void handleCallback(String callbackJson) {
        try {
            // Parse JSON callback data
            MpesaCallbackData callbackData = parseCallbackJson(callbackJson);

            // Process the callback data
            LOGGER.info("Handling M-Pesa callback. Merchant Request ID: {}, Checkout Request ID: {}",
                    callbackData.getMerchantRequestID(), callbackData.getCheckoutRequestID());

            // Store callback data in the database
            persistCallbackData(callbackData, null);
        } catch (JsonException e) {
            LOGGER.error("Failed to parse JSON callback data. Response: {}", callbackJson);
            throw new RuntimeException("Failed to parse JSON callback data");
        }
    }

    private MpesaCallbackData parseCallbackJson(String callbackJson) {
        try {
            Jsonb jsonb = JsonbBuilder.create();
            return jsonb.fromJson(callbackJson, MpesaCallbackData.class);
        } catch (JsonException e) {
            throw new RuntimeException("Failed to parse JSON callback data", e);
        }
    }

    private void persistCallbackData(MpesaCallbackData callbackData, MpesaTransaction payment) {
        if (payment == null) {
            payment = new MpesaTransaction();
        } else {
            // Update M-Pesa details in the Payment entity
            payment.setMerchantRequestId(callbackData.getMerchantRequestID());
            payment.setCheckoutRequestId(callbackData.getCheckoutRequestID());
            payment.setResponseCode(String.valueOf(callbackData.getResultCode()));
            payment.setResponseDescription(callbackData.getResultDesc());
            payment.setCustomerMessage(callbackData.getCallbackMetadata());

            database.merge(payment);
        }
    }

    @Override
    public boolean isPaymentMade(Long userId, Long eventId) {
        Payment payment = (Payment) database.createNativeQuery(
                "SELECT * FROM payments WHERE user_id = ? AND event_id = ?",
                Payment.class)
                .setParameter(1, userId)
                .setParameter(2, eventId)
                .getSingleResult();

        return payment.isPaid();
    }
}
