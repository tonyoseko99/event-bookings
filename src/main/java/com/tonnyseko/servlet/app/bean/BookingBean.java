package com.tonnyseko.servlet.app.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tonnyseko.servlet.app.model.entity.Event;
import com.tonnyseko.servlet.database.Database;

public class BookingBean implements BookingBeanInterface, Serializable {
    public String listOfBookings() {
        List<Event> events = Database.getDbInstance().getEvents();

        StringBuilder sb = new StringBuilder();
        sb.append("<ul>");
        for (Event event : events) {
            sb.append("<li>");
            sb.append(event.getName());
            sb.append("</li>");
        }

        sb.append("</ul>");
        return sb.toString();

    }

    public Event addBooking(Event event) throws Exception {
        return null;
    }

    public void deleteBooking(Event event) {

    }
}
