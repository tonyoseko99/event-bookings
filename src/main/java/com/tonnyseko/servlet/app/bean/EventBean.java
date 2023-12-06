package com.tonnyseko.servlet.app.bean;

import java.util.List;

import com.tonnyseko.servlet.app.model.entity.Event;
import com.tonnyseko.servlet.app.model.view.CategoryStatus;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;


public class EventBean extends GenericBean<Event> implements EventInterface {

    @Override
    public List<Event> getEventsByCategory(CategoryStatus category) {
        return null;
    }

    @Override
    public List<Event> getFeaturedEvent() {
        return null;
    }
}
