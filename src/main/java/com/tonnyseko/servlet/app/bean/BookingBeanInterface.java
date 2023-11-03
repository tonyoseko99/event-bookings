package com.tonnyseko.servlet.app.bean;

import com.tonnyseko.servlet.app.model.Booking;

public interface BookingBeanInterface {
    public String listOfBookings();
    public Booking addBooking(Booking account) throws Exception;
    public void deleteBooking(Booking account);
    
}
