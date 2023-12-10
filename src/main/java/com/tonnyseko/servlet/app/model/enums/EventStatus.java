package com.tonnyseko.servlet.app.model.enums;

public enum EventStatus {
    UPCOMING ("Upcoming"),
    ONGOING ("Ongoing"),
    PAST ("Past");

    private String value;

    // constructor
    private EventStatus(String value) {
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
