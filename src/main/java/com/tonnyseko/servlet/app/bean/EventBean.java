package com.tonnyseko.servlet.app.bean;

import java.io.Serializable;
import java.util.List;

import com.tonnyseko.servlet.app.model.entity.Event;
import com.tonnyseko.servlet.database.Database;

public class EventBean implements EventInterface, Serializable {
    public String listOfBookings() {
        List<Event> events = Database.getDbInstance().getEvents();

        StringBuilder sb = new StringBuilder();
        for (Event event : events) {
            sb.append("<div class=\"card-section\">");
            sb.append("<div class=\"card\">");
            sb.append("<div class=\"card-content\">");
            sb.append("<img src=\"").append(event.getImage()).append("\" alt=\"").append(event.getName()).append("\" style=\"width:100%\">");
            sb.append("<h2>").append(event.getName()).append("</h2>");
            sb.append("<p>").append("Venue: ").append(event.getVenue()).append("</p>");
            sb.append("<p>").append("Date: ").append(event.getDate()).append("</p>");
            sb.append("<p>").append("Time: ").append(event.getTime()).append("</p>");
            sb.append("<p>").append("Guests: ").append(event.getGuests()).append("</p>");
            sb.append("<p>").append("Description: ").append(event.getDescription()).append("</p>");
            sb.append("</div>");
            sb.append("</div>");
            sb.append("</div>");
        }

        return sb.toString();

    }

    public Event addBooking(Event event) throws Exception {
        Database db = Database.getDbInstance();
        db.getEvents().add(event);
        return event;
    }

    public void deleteBooking(Event event) {
        Database db = Database.getDbInstance();
        db.getEvents().remove(event);
    }
}
