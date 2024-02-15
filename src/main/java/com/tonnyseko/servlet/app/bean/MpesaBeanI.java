package com.tonnyseko.servlet.app.bean;

import java.io.Serializable;

public interface MpesaBeanI extends Serializable {
    String getAccessToken();

    String initiateOnlinePayment(String phoneNumber, double amount, String accountReference, String transactionDesc);

    void handleCallback(String callbackJson);

    boolean isPaymentMade(Long userId, Long eventId);
}
