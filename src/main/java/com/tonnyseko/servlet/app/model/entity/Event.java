package com.tonnyseko.servlet.app.model.entity;

import com.tonnyseko.servlet.app.view.helper.FormFieldType;
import com.tonnyseko.servlet.app.view.helper.HtmlCard;
import com.tonnyseko.servlet.app.view.helper.HtmlForm;
import com.tonnyseko.servlet.app.view.helper.HtmlFormField;

import javax.persistence.Column;

import com.tonnyseko.servlet.app.model.view.CategoryStatus;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Time;

@Entity
@Table(name = "events")
@HtmlCard(url = "/events?action=add")
@HtmlForm(label = "Add Event", url = "/events")
public class Event extends BaseEntity {

    @Column(name = "name")
    @HtmlFormField(label = "Name", name = "name")
    private String name;
    @Column(name = "image")
    @HtmlFormField(label = "Image", name = "image")
    private String image;
    @Column(name = "venue")
    @HtmlFormField(label = "Venue", name = "venue")
    private String venue;
    @Column(name = "date")
    @HtmlFormField(label = "Date", name = "date", type = FormFieldType.DATE)
    private String date;
    @Column(name = "time")
    @HtmlFormField(label = "Time", name = "time", type = FormFieldType.TIME)
    private String time;
    @Column(name = "category")
    @HtmlFormField(label = "Category", name = "category", type = FormFieldType.SELECT, options = {"TECHNOLOGY", "BUSINESS", "SPORTS", "ENTERTAINMENT", "OTHER"})
    private CategoryStatus category;
    @Column(name = "description")
    @HtmlFormField(label = "Description", name = "description", type = FormFieldType.TEXTAREA)
    private String description;

    public Event() {

    }

    public Event(String name, String image, String venue, String date, String time, CategoryStatus category, String description) {
        this.name = name;
        this.image = image;
        this.venue = venue;
        this.date = date;
        this.time = String.valueOf(Time.valueOf(time));
        this.category = category;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public CategoryStatus getCategory() {
        return category;
    }

    public void setCategory(CategoryStatus category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
