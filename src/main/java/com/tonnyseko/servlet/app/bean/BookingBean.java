package com.tonnyseko.servlet.app.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tonnyseko.servlet.app.model.entity.Event;

public class BookingBean implements BookingBeanInterface, Serializable {
    public String listOfBookings() {
        List<Event> events = new ArrayList<>();
        events.add(new Event("DevFest", "Nairobi, Kenya", "2020-01-01", "12:00", "2", "A GDG Tech Event 2023"));

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
