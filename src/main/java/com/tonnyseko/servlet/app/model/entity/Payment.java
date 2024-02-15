package com.tonnyseko.servlet.app.model.entity;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
@Table(name = "payments", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "reservation_id", "user_id" })
})
public class Payment extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "mpesa_transaction_id")
    @Cascade(CascadeType.ALL)
    private MpesaTransaction mpesaTransaction;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @Column(name = "amount")
    private double amount;

    @Column(name = "payment_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;

    // New method to update payment date from Mpesa callback metadata or use current
    // timestamp
    private void updatePaymentDateFromCallbackMetadata(String callbackMetadata) {
        try {
            JsonNode metadataJson = new ObjectMapper().readTree(callbackMetadata);
            JsonNode callbackNode = metadataJson.findPath("stkCallback");
            JsonNode metadataItemsNode = callbackNode.findPath("CallbackMetadata").findPath("Item");

            if (metadataItemsNode.isArray()) {
                for (JsonNode itemNode : metadataItemsNode) {
                    String name = itemNode.findPath("Name").asText();
                    String value = itemNode.findPath("Value").asText();

                    // Check if the item is "TransactionDate"
                    if ("TransactionDate".equals(name)) {
                        // Assuming value is a timestamp, you need to parse it into a Date
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                        Date transactionDate = dateFormat.parse(value);

                        // Set the payment date in your Payment entity
                        this.paymentDate = transactionDate;
                        break; // Exit the loop once TransactionDate is found
                    }
                }
            }
        } catch (Exception e) {
            // Handle JSON parsing or date parsing exception as needed
            e.printStackTrace(); // Log or throw an exception, based on your error handling strategy
        }
    }

    private String parsePaymentData(String callbackMetadata) {
        try {
            JsonNode metadataJson = new ObjectMapper().readTree(callbackMetadata);
            JsonNode callbackNode = metadataJson.findPath("stkCallback");
            JsonNode transactionDateNode = callbackNode.findPath("CallbackMetadata")
                    .findPath("Item")
                    .elements()
                    .next()
                    .findPath("Value");

            return (transactionDateNode != null) ? transactionDateNode.asText() : null;
        } catch (IOException e) {
            // Handle JSON parsing exception as needed
            return null;
        }
    }

    // check if payment is made
    public boolean isPaid() {
        return paymentDate != null;
    }

    // fetch ticket price from event
    public double getTicketPrice() {
        return event.getTicketPrice();
    }

    public Payment() {
    }

    public Payment(User user, Reservation reservation, Event event, double amount, Date paymentDate) {
        this.user = user;
        this.reservation = reservation;
        this.event = event;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public User getUser() {
        return user;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
        this.amount = event.getTicketPrice();
    }

    public double getAmount() {
        return amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public boolean isNew() {
        return getId() == null;
    }

}
