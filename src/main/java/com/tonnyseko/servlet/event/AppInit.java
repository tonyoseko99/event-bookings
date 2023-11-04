package com.tonnyseko.servlet.event;

import com.tonnyseko.servlet.app.model.entity.Event;
import com.tonnyseko.servlet.database.Database;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppInit implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Database instance created");

        Database db = Database.getDbInstance();

//        add some data to the database events
        db.getEvents().add(new Event("DevFest", "Nairobi, Kenya", "2020-01-01", "12:00", "2", "A GDG Tech Event 2023"));
        db.getEvents().add(new Event("DroidCon", "Nairobi, Kenya", "2020-01-01", "12:00", "2", "An Android Tech Event 2023"));
        db.getEvents().add(new Event("I/O Extended", "Nairobi, Kenya", "2020-01-01", "12:00", "2", "A Google Tech Event 2023"));
        db.getEvents().add(new Event("Flutter Live", "Nairobi, Kenya", "2020-01-01", "12:00", "2", "A Flutter Tech Event 2023"));
        db.getEvents().add(new Event("Google Cloud Next", "Nairobi, Kenya", "2020-01-01", "12:00", "2", "A Google Cloud Tech Event 2023"));
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Database instance destroyed");
    }
}
