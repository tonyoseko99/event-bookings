package com.tonnyseko.servlet.app.model.view;

public enum CategoryStatus {

    TECHNOLOGY("Technology"),
    BUSINESS("Business"),
    SPORTS("Sports"),
    ENTERTAINMENT("Entertainment"),
    OTHER("Other");

    private String value;

    // constructor
    private CategoryStatus(String value) {
        this.value = value;
    }

    // getter
    public String getValue() {
        return value;
    }

    // setter
    public void setValue(String value) {
        this.value = value;
    }
}

