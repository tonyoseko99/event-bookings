// HtmlCpmRender.java
package com.tonnyseko.servlet.app.helpers;

import com.tonnyseko.servlet.app.model.entity.Event;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;

public class HtmlCpmRender implements Serializable {

    public static String card(List<Event> events) {
        StringBuilder sb = new StringBuilder();

        // Add a button to add new event
        sb.append("<div class=\"add-event\">");
        sb.append("<a href=\"./events?action=add\" class=\"add-event-btn\">Add Event</a>");
        sb.append("</div>");

        // Add a div to encapsulate the event cards
        sb.append("<div class=\"event-cards\">");

        for (Event event : events) {
            sb.append("<div class=\"event-card\">");
            sb.append("<img src=\"").append(event.getImage()).append("\" alt=\"").append(event.getName())
                    .append("\" class=\"event-image\">");
            sb.append("<div class=\"event-details\">");
            sb.append("<h2 class=\"event-title\">").append(event.getName()).append("</h2>");
            sb.append("<p class=\"event-description\">").append(event.getDescription()).append("</p>");
            sb.append("<ul class=\"event-info\">");
            sb.append("<li><span class=\"event-label\">Venue:</span> ").append(event.getVenue()).append("</li>");
            sb.append("<li><span class=\"event-label\">Date:</span> ").append(event.getDate()).append("</li>");
            sb.append("<li><span class=\"event-label\">Time:</span> ").append(event.getTime()).append("</li>");
            sb.append("<li><span class=\"event-label\">Category:</span> ").append(event.getCategory()).append("</li>");
            sb.append("</ul>");

            // rsvp button
            sb.append("<div class=\"rsvp-btn\">");
            // view event button
            sb.append("<a href=\"./events?action=view&id=").append(event.getId())
                    .append("\" class=\"view-event-btn\">View Event</a>");
            // rsvp button
            sb.append("<a href=\"./reservations?action=rsvp&id=").append(event.getId())
                    .append("\" class=\"rsvp-event-btn\">RSVP</a>");

            sb.append("</div>");
            sb.append("</div>");
            sb.append("</div>");
        }

        sb.append("</div>");

        return sb.toString();
    }

    public static <T> String table(List<T> items) {
        StringBuilder sb = new StringBuilder();

        if (!items.isEmpty()) {
            sb.append("<table>");

            // Add table header
            sb.append("<tr>");
            Field[] fields = items.get(0).getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(HtmlTableColumn.class)) {
                    HtmlTableColumn column = field.getAnnotation(HtmlTableColumn.class);
                    sb.append("<th>").append(column.header()).append("</th>");
                }
            }
            sb.append("</tr>");

            // Add table rows
            for (T item : items) {
                sb.append("<tr>");
                for (Field field : fields) {
                    if (field.isAnnotationPresent(HtmlTableColumn.class)) {
                        try {
                            field.setAccessible(true);
                            Object value = field.get(item);
                            sb.append("<td>").append(value != null ? value.toString() : "").append("</td>");
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
                sb.append("</tr>");
            }

            sb.append("</table>");
        }

        return sb.toString();
    }

    private static Field[] getAllFields(Class<?> model) {
        List<Field> fields = new ArrayList<>();
        for (Field field : model.getDeclaredFields()) {
            fields.add(field);
        }

        if (model.getSuperclass() != null) {
            for (Field field : getAllFields(model.getSuperclass())) {
                fields.add(field);
            }
        }

        return fields.toArray(new Field[0]);
    }

    public static String form(Class<?> model) {
        return form(model, null, null);
    }

    // public static String form(Class<?> model, String eventId, String userId) {

    //     HtmlForm htmlFormMarker = null;
    //     if (model.isAnnotationPresent(HtmlForm.class))
    //         htmlFormMarker = model.getAnnotation(HtmlForm.class);

    //     if (htmlFormMarker == null)
    //         return StringUtils.EMPTY;

    //     StringBuilder htmlForm = new StringBuilder("<br/><h3>Add " + htmlFormMarker.label() + "</h3><br/>" +
    //             "<form class=\"add-form\" action=\"" + htmlFormMarker.url() + "\" method=\""
    //             + htmlFormMarker.httpMethod() + "\">" +
    //             "<div class=\"form-container\">");

    //     Field[] fields = model.getDeclaredFields();

    //     for (Field field : fields) {
    //         if (!field.isAnnotationPresent(HtmlFormField.class))
    //             continue;

    //         HtmlFormField formField = field.getAnnotation(HtmlFormField.class);

    //         String fieldName = field.getName();

    //         htmlForm
    //                 .append("<label for=\"").append(ifBlank(formField.labelFor(), fieldName)).append("\">")
    //                 .append(ifBlank(formField.label(), fieldName))
    //                 .append(formField.required() ? "<span style=\"color:red;\">*</span> " : "")
    //                 .append(":</label><br>");

    //         if (field.getType().isEnum()) {
    //             htmlForm.append("<select name=\"").append(fieldName).append("\">");
    //             for (Object enumConstant : field.getType().getEnumConstants()) {
    //                 htmlForm.append("<option value=\"").append(enumConstant).append("\">").append(enumConstant)
    //                         .append("</option>");
    //             }
    //             htmlForm.append("</select>");
    //         }

    //         else {
    //             htmlForm.append("<input type=\"").append(formField.type()).append("\" name=\"").append(fieldName)
    //                     .append("\"");
    //             if (formField.required())
    //                 htmlForm.append(" required");
    //             htmlForm.append("><br>");
    //         }
    //         if (field.isAnnotationPresent(Embedded.class)) {
    //             for (Field embeddedField : field.getType().getDeclaredFields()) {
    //                 if (!embeddedField.isAnnotationPresent(HtmlFormField.class))
    //                     continue;

    //                 HtmlFormField formField1 = embeddedField.getAnnotation(HtmlFormField.class);

    //                 String fieldName1 = field.getName() + "." + embeddedField.getName();

    //                 htmlForm
    //                         .append("<label for=\"").append(ifBlank(formField1.labelFor(), fieldName1)).append("\">")
    //                         .append(ifBlank(formField1.label(), fieldName1))
    //                         .append(formField1.required() ? "<span style=\"color:red;\">*</span> " : "")
    //                         .append(":</label><br>");

    //                 htmlForm.append("<input type=\"").append(formField1.type()).append("\" name=\"").append(fieldName1)
    //                         .append("\"");
    //                 if (formField1.required())
    //                     htmlForm.append(" required");
    //                 htmlForm.append("><br>");
    //             }
    //         }

    //     }

    //     // Add hidden eventId field
    //     if (eventId != null) {
    //         htmlForm.append("<input type=\"hidden\" name=\"event_id\" value=\"").append(eventId).append("\">");
    //     }

    //     // Add hidden userId field
    //     if (userId != null) {
    //         htmlForm.append("<input type=\"hidden\" name=\"user_id\" value=\"").append(userId).append("\">");
    //     }

    //     htmlForm.append("<button class=\"submit-btn\" type=\"submit\">Submit</button>");
    //     htmlForm.append("</div>" + "</form>" + "<br/>");

    //     return htmlForm.toString();

    // }

    public static String form(Class<?> model, String eventId, String userId) {

        HtmlForm htmlFormMarker = null;
        if (model.isAnnotationPresent(HtmlForm.class))
            htmlFormMarker = model.getAnnotation(HtmlForm.class);
    
        if (htmlFormMarker == null)
            return StringUtils.EMPTY;
    
        StringBuilder htmlForm = new StringBuilder("<br/><h3>Add " + htmlFormMarker.label() + "</h3><br/>" +
                "<form class=\"add-form\" action=\"" + htmlFormMarker.url() + "\" method=\""
                + htmlFormMarker.httpMethod() + "\">" +
                "<div class=\"form-container\">");
    
        Field[] fields = model.getDeclaredFields();
    
        for (Field field : fields) {
            if (field.isAnnotationPresent(HtmlFormField.class)) {
                HtmlFormField formField = field.getAnnotation(HtmlFormField.class);
                String fieldName = field.getName();
                appendFormField(htmlForm, formField, fieldName, field.getType());
            } else if (field.isAnnotationPresent(Embedded.class)) {
                for (Field embeddedField : field.getType().getDeclaredFields()) {
                    if (!embeddedField.isAnnotationPresent(HtmlFormField.class))
                        continue;
    
                    HtmlFormField formField = embeddedField.getAnnotation(HtmlFormField.class);
                    String fieldName = field.getName() + "." + embeddedField.getName();
                    appendFormField(htmlForm, formField, fieldName, embeddedField.getType());
                }
            }
        }
    
        // Add hidden eventId field
        if (eventId != null) {
            htmlForm.append("<input type=\"hidden\" name=\"event_id\" value=\"").append(eventId).append("\">");
        }
    
        // Add hidden userId field
        if (userId != null) {
            htmlForm.append("<input type=\"hidden\" name=\"user_id\" value=\"").append(userId).append("\">");
        }
    
        htmlForm.append("<button class=\"submit-btn\" type=\"submit\">Submit</button>");
        htmlForm.append("</div>" + "</form>" + "<br/>");
    
        return htmlForm.toString();
    }
    
    private static void appendFormField(StringBuilder htmlForm, HtmlFormField formField, String fieldName, Class<?> fieldType) {
        htmlForm
                .append("<label for=\"").append(ifBlank(formField.labelFor(), fieldName)).append("\">")
                .append(ifBlank(formField.label(), fieldName))
                .append(formField.required() ? "<span style=\"color:red;\">*</span> " : "")
                .append(":</label><br>");
    
        if (fieldType.isEnum()) {
            htmlForm.append("<select name=\"").append(fieldName).append("\">");
            for (Object enumConstant : fieldType.getEnumConstants()) {
                htmlForm.append("<option value=\"").append(enumConstant).append("\">").append(enumConstant)
                        .append("</option>");
            }
            htmlForm.append("</select>");
        } else {
            htmlForm.append("<input type=\"").append(formField.type()).append("\" name=\"").append(fieldName)
                    .append("\"");
            if (formField.required())
                htmlForm.append(" required");
            htmlForm.append("><br>");
        }
    }

    private static String ifBlank(String target, String alternative) {
        return StringUtils.isBlank(target) ? alternative : StringUtils.trimToEmpty(target);
    }
}
