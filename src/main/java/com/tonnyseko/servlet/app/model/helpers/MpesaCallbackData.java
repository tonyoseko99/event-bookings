package com.tonnyseko.servlet.app.model.helpers;

import java.io.Serializable;
import java.util.Map;

public class MpesaCallbackData implements Serializable{
    private String MerchantRequestID;
    private String CheckoutRequestID;
    private int ResultCode;
    private String ResultDesc;
    private Map<String, String> CallbackMetadata;

    public String getMerchantRequestID() {
        return MerchantRequestID;
    }

    public void setMerchantRequestID(String merchantRequestID) {
        MerchantRequestID = merchantRequestID;
    }

    public String getCheckoutRequestID() {
        return CheckoutRequestID;
    }

    public void setCheckoutRequestID(String checkoutRequestID) {
        CheckoutRequestID = checkoutRequestID;
    }

    public int getResultCode() {
        return ResultCode;
    }

    public void setResultCode(int resultCode) {
        ResultCode = resultCode;
    }

    public String getResultDesc() {
        return ResultDesc;
    }

    public void setResultDesc(String resultDesc) {
        ResultDesc = resultDesc;
    }

    public Map<String, String> getCallbackMetadata() {
        return CallbackMetadata;
    }

    public void setCallbackMetadata(Map<String, String> callbackMetadata) {
        CallbackMetadata = callbackMetadata;
    }

    @Override
    public String toString() {
        return "MpesaCallbackData [CallbackMetadata=" + CallbackMetadata + ", CheckoutRequestID=" + CheckoutRequestID
                + ", MerchantRequestID=" + MerchantRequestID + ", ResultCode=" + ResultCode + ", ResultDesc="
                + ResultDesc + "]";
    }
}
