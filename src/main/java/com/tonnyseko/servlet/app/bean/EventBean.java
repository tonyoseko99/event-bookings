package com.tonnyseko.servlet.app.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tonnyseko.servlet.app.model.entity.Event;
import com.tonnyseko.servlet.app.model.view.CategoryStatus;
import com.tonnyseko.servlet.database.Database;

public class EventBean extends GenericBean<Event> implements EventInterface {


    public List<Event> getEventsByCategory(CategoryStatus valueOf) {
        return null;
    }

    public List<Event> getFeaturedEvent() {
        return null;
    }

}
