// HtmlCpmRender.java
package com.tonnyseko.servlet.app.view.helper;

import com.tonnyseko.servlet.app.model.Event;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

public class HtmlCpmRender implements Serializable {

    public static String card(List<Event> events) {
        StringBuilder sb = new StringBuilder();
            sb.append("<div class=\"card-section\">");
            sb.append("<div class=\"card-content\">");

        for (Event event : events) {

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

    public static String form(Class<?> model) {

        StringBuilder sb = new StringBuilder();
        sb.append("<form>");
        for (Field field : model.getDeclaredFields()) {
            sb.append("<label for=\"").append(field.getName()).append("\">").append(field.getName()).append("</label>");
            sb.append("<input type=\"text\" id=\"").append(field.getName()).append("\" name=\"").append(field.getName()).append("\">");
            sb.append("<br>");
        }
        sb.append("<input type=\"submit\" value=\"Submit\">");
        sb.append("</form>");
        return sb.toString();
    }
        // Placeholder logic for rendering a form
}
