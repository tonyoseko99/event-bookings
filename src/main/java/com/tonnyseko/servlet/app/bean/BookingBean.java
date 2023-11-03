package com.tonnyseko.servlet.app.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tonnyseko.servlet.app.model.Booking;

public class BookingBean implements Serializable {
    public String listOfBookings() {
        List<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking("John Doe", "j@test.com", "0712345678", "2020-01-01", "12:00", "2", "Test message"));

        StringBuilder sb = new StringBuilder();
        sb.append("<ul>");
        for (Booking booking : bookings) {
            sb.append("<li>");
            sb.append(booking.getName());
            sb.append("</li>");
        }

        sb.append("</ul>");
        return sb.toString();

    }

    public Booking addBooking(Booking account) throws Exception {
        return null;
    }

    public void deleteBooking(Booking account) throws Exception {

    }
}
