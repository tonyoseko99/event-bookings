package com.tonnyseko.servlet.app.model.helpers;

import java.io.Serializable;
import java.util.Map;

public class MpesaCallbackData implements Serializable {
    private String merchantRequestID;
    private String checkoutRequestID;
    private int resultCode;
    private String resultDesc;
    private String callbackMetadata;

    public MpesaCallbackData() {
    }

    public MpesaCallbackData(Map<String, String[]> parameterMap) {
        // Initialize fields from the parameter map
        this.merchantRequestID = getParameter(parameterMap, "MerchantRequestID");
        this.checkoutRequestID = getParameter(parameterMap, "CheckoutRequestID");

        // Handle conversion to int for ResultCode
        String resultCodeStr = getParameter(parameterMap, "ResultCode");
        this.resultCode = (resultCodeStr != null) ? Integer.parseInt(resultCodeStr) : 0;

        this.resultDesc = getParameter(parameterMap, "ResultDesc");
        this.callbackMetadata = getParameter(parameterMap, "CallbackMetadata");
    }

    private String getParameter(Map<String, String[]> parameterMap, String parameterName) {
        String[] values = parameterMap.get(parameterName);
        return (values != null && values.length > 0) ? values[0] : null;
    }

    public String getMerchantRequestID() {
        return merchantRequestID;
    }

    public void setMerchantRequestID(String merchantRequestID) {
        this.merchantRequestID = merchantRequestID;
    }

    public String getCheckoutRequestID() {
        return checkoutRequestID;
    }

    public void setCheckoutRequestID(String checkoutRequestID) {
        this.checkoutRequestID = checkoutRequestID;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public String getCallbackMetadata() {
        return callbackMetadata;
    }

    public void setCallbackMetadata(String callbackMetadata) {
        this.callbackMetadata = callbackMetadata;
    }
}
