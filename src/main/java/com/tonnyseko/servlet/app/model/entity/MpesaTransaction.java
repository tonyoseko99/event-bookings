package com.tonnyseko.servlet.app.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "mpesa_transactions")
public class MpesaTransaction extends BaseEntity {

    @Column(name = "merchant_request_id")
    private String merchantRequestId;

    @Column(name = "checkout_request_id")
    private String checkoutRequestId;

    @Column(name = "response_code")
    private String responseCode;

    @Column(name = "response_description")
    private String responseDescription;

    @Column(name = "customer_message")
    private String customerMessage;

    // getters and setters

    public String getMerchantRequestId() {
        return merchantRequestId;
    }

    public void setMerchantRequestId(String merchantRequestId) {
        this.merchantRequestId = merchantRequestId;
    }

    public String getCheckoutRequestId() {
        return checkoutRequestId;
    }

    public void setCheckoutRequestId(String checkoutRequestId) {
        this.checkoutRequestId = checkoutRequestId;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String resultCode) {
        this.responseCode = resultCode;
    }

    public String getResponseDescription() {
        return responseDescription;
    }

    public void setResponseDescription(String resultDescription) {
        this.responseDescription = resultDescription;
    }

    public String getCustomerMessage() {
        return customerMessage;
    }

    public void setCustomerMessage(String customerMessage) {
        this.customerMessage = customerMessage;
    }

}
