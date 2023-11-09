package com.tonnyseko.servlet.app.bean;

import java.io.Serializable;
import java.util.List;

import com.tonnyseko.servlet.app.model.entity.Event;
import com.tonnyseko.servlet.app.model.view.CategoryStatus;
import com.tonnyseko.servlet.database.Database;

public class EventBean implements EventInterface, Serializable {
    public String listOfBookings() {
        List<Event> events = Database.getDbInstance().getEvents();

        StringBuilder sb = new StringBuilder();
        for (Event event : events) {

            sb.append("<div class=\"card-section\">");
            sb.append("<div class=\"card-content\">");
            sb.append("<img src=\"").append(event.getImage()).append("\" alt=\"").append(event.getName())
                    .append("\" style=\"width:100%\">");
            sb.append("<h2>").append(event.getName()).append("</h2>");
            sb.append("<p>").append("Venue: ").append(event.getVenue()).append("</p>");
            sb.append("<p>").append("Date: ").append(event.getDate()).append("</p>");
            sb.append("<p>").append("Time: ").append(event.getTime()).append("</p>");
            sb.append("<p>").append("Category: ").append(event.getCategory()).append("</p>");
            sb.append("<p>").append("Description: ").append(event.getDescription()).append("</p>");
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

    public void addEvent(String name, String image, String venue, String date, String time, CategoryStatus category,
                         String description) {
        Database db = Database.getDbInstance();
        db.getEvents().add(new Event(name, image, venue, date, time, category, description));
    }

    public String getFeaturedEvent() {
        List<Event> events = Database.getDbInstance().getEvents();

        StringBuilder sb = new StringBuilder();
        if (!events.isEmpty()) {
            Event event = events.get(5);

//            // Create the left side of the container
//            sb.append("<div class=\"container\">");
//            sb.append("<div class=\"left-side\">");
//            sb.append("<h1>Welcome to Our Events Booking Platform</h1>");
//            sb.append("<p>Discover and book amazing events near you. Don't miss out!</p>");
//            sb.append("<a href=\"#\" class=\"btn\">View Events</a>");
//            sb.append("</div>");
//
//// Create the right side of the container with an image
//            sb.append("<div class=\"right-side\">");
//            sb.append("<img src=\"event_image.jpg\" alt=\"Event Image\">");
//            sb.append("</div>");
//            sb.append("</div>");


            sb.append("<div class=\"main-page-feature\">");

            sb.append("<img src=\"").append(event.getImage()).append("\" alt=\"").append(event.getName())
                    .append("\" style=\"width:100%\">");
            sb.append("<h2>").append(event.getName()).append("</h2>");
            sb.append("</div>");
        }

        sb.append("<div class=\"main-page-feature\">");
        sb.append("<a href=\"./events\" class=\"btn btn-primary\">View All Events</a>");
        sb.append("</div>");
        sb.append("<div class=\"main-page-feature\">");
        sb.append("<a href=\"./categories\" class=\"btn btn-primary\">View Categories</a>");
        sb.append("</div>");

        return sb.toString();
    }

    public List<Event> getEvents() {
        return Database.getDbInstance().getEvents();
    }

    public String getCategories() {
        // list of categories

        List<CategoryStatus> categories = List.of(CategoryStatus.values());

        StringBuilder sb = new StringBuilder();
        for (CategoryStatus category : categories) {
            sb.append("<div class=\"main-page-feature\">");
            sb.append("<a href=\"./categories?category=").append(category).append("\" class=\"btn btn-primary\">")
                    .append(category).append("</a>");
            sb.append("</div>");

        }

        return sb.toString();

    }

    public String sortPerCategory(CategoryStatus category) {
        StringBuilder sb = new StringBuilder();
        List<Event> events = Database.getDbInstance().getEvents();

        for (Event event : events) {
            if (event.getCategory().equals(category)) {
                sb.append("<div class=\"card-section\">");
                sb.append("<div class=\"card-content\">");
                sb.append("<img src=\"").append(event.getImage()).append("\" alt=\"").append(event.getName())
                        .append("\" style=\"width:100%\">");
                sb.append("<h2>").append(event.getName()).append("</h2>");
                sb.append("<p>").append("Venue: ").append(event.getVenue()).append("</p>");
                sb.append("<p>").append("Date: ").append(event.getDate()).append("</p>");
                sb.append("<p>").append("Time: ").append(event.getTime()).append("</p>");
                sb.append("<p>").append("Category: ").append(event.getCategory()).append("</p>");
                sb.append("<p>").append("Description: ").append(event.getDescription()).append("</p>");
                sb.append("</div>");
                sb.append("</div>");
            }
        }

        return sb.toString();

    }

}
