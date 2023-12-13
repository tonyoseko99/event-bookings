package com.tonnyseko.servlet.app.bean;

import java.util.List;

import com.tonnyseko.servlet.app.model.entity.Event;
import com.tonnyseko.servlet.app.model.enums.CategoryStatus;

public interface EventInterface extends GenericBeanI<Event> {

    List<Event> getEventsByCategory(CategoryStatus category);

    List<Event> getFeaturedEvent();

    Event findEventById(Long id);
}
