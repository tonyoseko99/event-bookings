package com.tonnyseko.servlet.app.bean;

import java.util.List;

import com.tonnyseko.servlet.app.model.entity.Event;
import com.tonnyseko.servlet.app.model.enums.CategoryStatus;

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
    public List<Event> getEventsByCategory(CategoryStatus category) {
        List<Event> events = database.createQuery("SELECT e FROM Event e WHERE e.category = :category", Event.class)
                .setParameter("category", category).getResultList();
        return events;
    }

    @Override
    public List<Event> getFeaturedEvent() {
        List<Event> events = database.createQuery("SELECT e FROM Event e WHERE e.category = :category", Event.class)
                .setParameter("category", CategoryStatus.TECHNOLOGY).setMaxResults(1).getResultList();
        return events;
    }

    @Override
    public Event findEventById(Long id) {
        return database.find(Event.class, id);
    }

}
