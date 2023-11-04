package com.tonnyseko.servlet.app.bean;

import com.tonnyseko.servlet.app.model.entity.Event;

public interface EventInterface {
    public String listOfBookings();
    public Event addBooking(Event event) throws Exception;
    public void deleteBooking(Event event);
    
}
