package com.tonnyseko.servlet.app.model.entity;

import com.tonnyseko.servlet.app.model.enums.CategoryStatus;
import com.tonnyseko.servlet.app.helpers.FormFieldType;
import com.tonnyseko.servlet.app.helpers.HtmlCard;
import com.tonnyseko.servlet.app.helpers.HtmlForm;
import com.tonnyseko.servlet.app.helpers.HtmlFormField;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

@Entity
@Table(name = "events")
@HtmlCard(url = "./events?action=add")
@HtmlForm(label = "Event", url = "/events")
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
    @Temporal(TemporalType.DATE)
    @HtmlFormField(label = "Date", name = "date", type = FormFieldType.DATE)
    private Date date;

    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    @HtmlFormField(label = "Time", name = "time", type = FormFieldType.TIME)
    private Date time;

    @Column(name = "category")
    @HtmlFormField(label = "Category", name = "category")
    @Enumerated(EnumType.STRING)
    private CategoryStatus category;

    @Column(name = "description")
    @HtmlFormField(label = "Description", name = "description", type = FormFieldType.TEXTAREA)
    private String description;

    public boolean isNew() {
        return getId() == null;
    }

    public Event() {

    }

    public Event(String name, String image, String venue, Date date, Date time, CategoryStatus category, String description) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
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
