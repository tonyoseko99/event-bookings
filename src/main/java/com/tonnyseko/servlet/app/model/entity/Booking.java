package com.tonnyseko.servlet.app.model.entity;

import org.apache.commons.lang3.StringUtils;
import java.io.Serializable;

public class Booking implements Serializable {

    private String name;
    private String email;
    private String phone;
    private String date;
    private String time;
    private String guests;
    private String message;

    public Booking() {

    }

    public Booking(String name, String email, String phone, String date, String time, String guests, String message) {
        super();
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.date = date;
        this.time = time;
        this.guests = guests;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getGuests() {
        return guests;
    }

    public String getMessage() {
        return message;
    }

    // create a stringbuilder to append the booking details in a list html format
    public String listStrings() {
        StringBuilder listBuilder = new StringBuilder();
        listBuilder.append("<ul>");
        listBuilder.append("<li>Name: ").append(StringUtils.trimToEmpty(getName())).append("</li>");
        listBuilder.append("<li>Email: ").append(StringUtils.trimToEmpty(getEmail())).append("</li>");
        listBuilder.append("<li>Phone: ").append(StringUtils.trimToEmpty(getPhone())).append("</li>");
        listBuilder.append("<li>Date: ").append(StringUtils.trimToEmpty(getDate())).append("</li>");
        listBuilder.append("<li>Time: ").append(StringUtils.trimToEmpty(getTime())).append("</li>");
        listBuilder.append("<li>Guests: ").append(StringUtils.trimToEmpty(getGuests())).append("</li>");
        listBuilder.append("<li>Message: ").append(StringUtils.trimToEmpty(getMessage())).append("</li>");
        listBuilder.append("</ul>");
        return listBuilder.toString();
    }
}
