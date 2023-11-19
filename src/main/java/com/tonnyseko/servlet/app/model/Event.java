package com.tonnyseko.servlet.app.model;

import com.tonnyseko.servlet.app.utils.AnnotationsPreProcessor;
import com.tonnyseko.servlet.app.view.helper.HtmlCard;
import com.tonnyseko.servlet.app.view.helper.HtmlForm;
import com.tonnyseko.servlet.app.view.helper.HtmlFormField;
import com.tonnyseko.servlet.database.helper.DbColumn;
import org.apache.commons.lang3.StringUtils;

import com.tonnyseko.servlet.app.model.view.CategoryStatus;

import java.io.Serializable;
import java.lang.reflect.Field;

@HtmlCard(url = "/events?action=add")
@HtmlForm(label = "Add Event", url = "/events")
public class Event implements Serializable {

    @DbColumn(columnName = "name")
    @HtmlFormField(label = "Name", name = "name")
    private String name;
    @DbColumn(columnName = "image")
    @HtmlFormField(label = "Image", name = "image")
    private String image;
    @DbColumn(columnName = "venue")
    @HtmlFormField(label = "Venue", name = "venue")
    private String venue;
    @DbColumn(columnName = "date")
    @HtmlFormField(label = "Date", name = "date")
    private String date;
    @DbColumn(columnName = "time")
    @HtmlFormField(label = "Time", name = "time")
    private String time;
    @DbColumn(columnName = "category")
    @HtmlFormField(label = "Category", name = "category")
    private CategoryStatus category;
    @DbColumn(columnName = "description")
    @HtmlFormField(label = "Description", name = "description")
    private String description;

    public Event() {

    }

    public Event(String name, String image, String venue, String date, String time, CategoryStatus category, String description) {
        super();
        this.name = name;
        this.image = image;
        this.venue = venue;
        this.date = date;
        this.time = time;
        this.category = category;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getVenue() {
        return venue;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public CategoryStatus getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    // create a stringbuilder to append the booking details in a list html format
    public String listStrings() {
        StringBuilder listBuilder = new StringBuilder();
        listBuilder.append("<ul>");

        Class<?> clazz = getClass();
        listBuilder.append(AnnotationsPreProcessor.processHtmlCardAnnotations(clazz));
        listBuilder.append(AnnotationsPreProcessor.processHtmlFormAnnotations(clazz));

        for (Field field : clazz.getDeclaredFields()) {
            listBuilder.append(AnnotationsPreProcessor.processHtmlFormFieldAnnotations(field));
        }

        listBuilder.append("</ul>");
        return listBuilder.toString();
    }
}
