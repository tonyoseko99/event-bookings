package com.tonnyseko.servlet.app.model.enums;

public enum Role {
    ADMIN("Admin"),
    USER("User");

    private String value;

    // constructor
    private Role(String value) {
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
