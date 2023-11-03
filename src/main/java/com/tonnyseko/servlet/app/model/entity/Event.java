package com.tonnyseko.servlet.app.model.entity;

import org.apache.commons.lang3.StringUtils;
import java.io.Serializable;

public class Event implements Serializable {

    private String name;
    private String venue;
    private String date;
    private String time;
    private String guests;
    private String description;

    public Event() {

    }

    public Event(String name, String venue, String date, String time, String guests, String description) {
        super();
        this.name = name;
        this.venue = venue;
        this.date = date;
        this.time = time;
        this.guests = guests;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getVenue() {
        return venue;
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

    public String getDescription() {
        return description;
    }

    // create a stringbuilder to append the booking details in a list html format
    public String listStrings() {
        StringBuilder listBuilder = new StringBuilder();
        listBuilder.append("<ul>");
        listBuilder.append("<li>Name: ").append(StringUtils.trimToEmpty(getName())).append("</li>");
        listBuilder.append("<li>Venue: ").append(StringUtils.trimToEmpty(getVenue())).append("</li>");
        listBuilder.append("<li>Date: ").append(StringUtils.trimToEmpty(getDate())).append("</li>");
        listBuilder.append("<li>Time: ").append(StringUtils.trimToEmpty(getTime())).append("</li>");
        listBuilder.append("<li>Guests: ").append(StringUtils.trimToEmpty(getGuests())).append("</li>");
        listBuilder.append("<li>Description: ").append(StringUtils.trimToEmpty(getDescription())).append("</li>");
        listBuilder.append("</ul>");
        return listBuilder.toString();
    }
}
