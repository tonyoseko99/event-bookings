package com.tonnyseko.servlet.app.bean;

import com.tonnyseko.servlet.app.model.entity.Event;

public interface EventInterface extends GenericBeanI<Event> {

    Event findEventById(Long id);
}
