// HtmlCpmRender.java
package com.tonnyseko.servlet.app.view.helper;

import com.tonnyseko.servlet.app.model.entity.Event;
import com.tonnyseko.servlet.app.model.view.CategoryStatus;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

public class HtmlCpmRender implements Serializable {

    public static String card(List<Event> events) {
        StringBuilder sb = new StringBuilder();

//        add a button to add new event
        sb.append("<div class=\"add-event\">");
        sb.append("<a href=\"/event/add\" class=\"add-event-btn\">Add Event</a>");
        sb.append("</div>");

        sb.append("<div class=\"event-card\">");

        for (Event event : events) {
            sb.append("<div class=\"event-item\">");
            sb.append("<img src=\"").append(event.getImage()).append("\" alt=\"").append(event.getName()).append("\" class=\"event-image\">");
            sb.append("<div class=\"event-details\">");
            sb.append("<h2 class=\"event-title\">").append(event.getName()).append("</h2>");
            sb.append("<p class=\"event-description\">").append(event.getDescription()).append("</p>");
            sb.append("<ul class=\"event-info\">");
            sb.append("<li><span class=\"event-label\">Venue:</span> ").append(event.getVenue()).append("</li>");
            sb.append("<li><span class=\"event-label\">Date:</span> ").append(event.getDate()).append("</li>");
            sb.append("<li><span class=\"event-label\">Time:</span> ").append(event.getTime()).append("</li>");
            sb.append("<li><span class=\"event-label\">Category:</span> ").append(event.getCategory()).append("</li>");
            sb.append("</ul>");

            sb.append("<a href=\"#\" class=\"event-btn\">View Event</a>");

            sb.append("</div>");
            sb.append("</div>");
        }

        sb.append("</div>");

        return sb.toString();
    }


    public static String form(Class<?> model) {

        HtmlForm htmlFormMarker = null;
        if (model.isAnnotationPresent(HtmlForm.class))
            htmlFormMarker = model.getAnnotation(HtmlForm.class);

        if (htmlFormMarker == null)
            return StringUtils.EMPTY;

        StringBuilder htmlForm = new StringBuilder("<br/><h3>Add " + htmlFormMarker.label() + "</h3><br/>" +
                "<form action=\"" + htmlFormMarker.url() + "\" method=\"" + htmlFormMarker.httpMethod() + "\">" +
                "<div class=\"container\">");

        Field [] fields = model.getDeclaredFields();

        for (Field field : fields) {
            if (!field.isAnnotationPresent(HtmlFormField.class))
                continue;

            HtmlFormField formField = field.getAnnotation(HtmlFormField.class);

            String fieldName = field.getName();

            htmlForm
                    .append("<label for=\"").append(ifBlank(formField.labelFor(), fieldName)).append("\">")
                    .append(ifBlank(formField.label(), fieldName))
                    .append(formField.required()?"<span style=\"color:red;\">*</span> ":"")
                    .append(":</label><br>");

            htmlForm.append("<input type=\"")
                    .append(formField.type())
                    .append("\" id=\"").append(ifBlank(formField.id(), fieldName))
                    .append("\" name=\"").append(ifBlank(formField.name(), fieldName)).append("\" ")
                    .append(formField.required()?"required" : "")
                    .append("><br>");

        }

        htmlForm.append("<button type=\"submit\">Submit</button>");
        htmlForm.append("</div>" + "</form>" + "<br/>");

        return htmlForm.toString();

    }
    private static String ifBlank(String target, String alternative){
        return StringUtils.isBlank(target)? alternative : StringUtils.trimToEmpty(target);
    }
}
