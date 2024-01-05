package com.tonnyseko.servlet.app.bean;

import com.tonnyseko.servlet.app.model.helpers.MpesaCallbackData;

import java.io.Serializable;

public interface MpesaBeanI extends Serializable {
    String getAccessToken();

    String initiateOnlinePayment(String phoneNumber, double amount, String accountReference, String transactionDesc);

    void handleCallback(MpesaCallbackData callbackData);
}
