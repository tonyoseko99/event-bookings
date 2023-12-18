package com.tonnyseko.servlet.app.bean;

import com.tonnyseko.servlet.app.model.entity.Event;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EventBean extends GenericBean<Event> implements EventInterface {
    @PersistenceContext
    private EntityManager database;

    @PostConstruct
    public void init() {
        System.out.println("EventBean initialized");
    }

    @Override
    public Event findEventById(Long id) {
        return database.find(Event.class, id);
    }

}
