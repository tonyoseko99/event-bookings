package com.tonnyseko.servlet.app.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tonnyseko.servlet.app.model.entity.Event;

public class BookingBean implements BookingBeanInterface, Serializable {
    public String listOfBookings() {
        List<Event> bookings = new ArrayList<>();
        bookings.add(new Event("John Doe", "j@test.com", "0712345678", "2020-01-01", "12:00", "2", "Test message"));

        StringBuilder sb = new StringBuilder();
        sb.append("<ul>");
        for (Event booking : bookings) {
            sb.append("<li>");
            sb.append(booking.getName());
            sb.append("</li>");
        }

        sb.append("</ul>");
        return sb.toString();

    }

    public Event addBooking(Event account) throws Exception {
        return null;
    }

    public void deleteBooking(Event account) {

    }
}
