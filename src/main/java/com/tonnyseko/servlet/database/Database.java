package com.tonnyseko.servlet.database;

import com.tonnyseko.servlet.app.model.entity.Event;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Database implements Serializable {
    private List<Event> events = new ArrayList<>();
    private static Database dbInstance;

    public Database() {}
    public static Database getDbInstance() {
        if(dbInstance == null) {
            dbInstance = new Database();
            System.out.println("Database instance created");
        }
        return dbInstance;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        if(events != null) {
            this.events = events;
        }
    }
}
