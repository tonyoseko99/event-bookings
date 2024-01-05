package com.tonnyseko.servlet.app.model.helpers;

import java.io.Serializable;

public class PaymentRequest implements Serializable{
    private String phoneNumber;
    private double amount;
    private String accountReference;
    private String transactionDesc;

    public PaymentRequest() {
    }

    public PaymentRequest(String phoneNumber, double amount, String accountReference, String transactionDesc) {
        this.phoneNumber = phoneNumber;
        this.amount = amount;
        this.accountReference = accountReference;
        this.transactionDesc = transactionDesc;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getAmount() {
        return amount;
    }

    public String getAccountReference() {
        return accountReference;
    }

    public String getTransactionDesc() {
        return transactionDesc;
    }

    // @Override
    // public String toString() {
    //     return "PaymentRequest [accountReference=" + accountReference + ", amount=" + amount + ", phoneNumber="
    //             + phoneNumber + ", transactionDesc=" + transactionDesc + "]";
    // }
}
