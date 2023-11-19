package com.tonnyseko.servlet.app.bean;

import com.tonnyseko.servlet.app.model.Event;

import java.util.List;

public interface EventInterface {
    public List<Event> listOfBookings();
    public Event addBooking(Event event) throws Exception;
    public void deleteBooking(Event event);
    
}
