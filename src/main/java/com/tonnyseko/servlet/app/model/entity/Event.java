package com.tonnyseko.servlet.app.model.entity;

import com.tonnyseko.servlet.app.helpers.HtmlCard;
import com.tonnyseko.servlet.app.model.enums.CategoryStatus;
import com.tonnyseko.servlet.app.helpers.FormFieldType;
import com.tonnyseko.servlet.app.helpers.HtmlForm;
import com.tonnyseko.servlet.app.helpers.HtmlFormField;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "events")
@HtmlCard(url = "./events?action=add")
@HtmlForm(label = "Event", url = "./events")
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
    @HtmlFormField(label = "Time", name = "time", type = FormFieldType.TIME)
    private Time time;

    @Column(name = "category")
    @HtmlFormField(label = "Category", name = "category")
    @Enumerated(EnumType.STRING)
    private CategoryStatus category;

    // event capacity
    // @Column(name = "capacity")
    // @HtmlFormField(label = "Capacity", name = "capacity", type = FormFieldType.NUMBER)
    // private Integer capacity;

    // @Column(name = "status")
    // @HtmlFormField(label = "Status", name = "status")
    // @Enumerated(EnumType.STRING)
    // private EventStatus status;

    @Column(name = "description")
    @HtmlFormField(label = "Description", name = "description", type = FormFieldType.TEXTAREA)
    private String description;

    @OneToMany(mappedBy = "event")
    private List<Reservation> reservations;

    public boolean isNew() {
        return getId() == null;
    }

    public Event() {

    }

    public Event(Long id) {
        setId(id);
    }

    public Event(Long id, String name, String image, String venue, Date date, Time time, CategoryStatus category, String description) {
        setId(id);
        this.name = name;
        this.image = image;
        this.venue = venue;
        this.date = date;
        this.time = time;
        this.category = category;
        // this.capacity = capacity;
        // this.status = status;
        this.description = description;
    }

    public Event(String name, String image, String venue, Date date, Time time, CategoryStatus category, String description) {
        this.name = name;
        this.image = image;
        this.venue = venue;
        this.date = date;
        this.time = time;
        this.category = category;
        // this.capacity = capacity;
        // this.status = status;
        this.description = description;
    }

    // get id
    public Long getId() {
        return super.getId();
    }

    // set id
    public void setId(Long id) {
        super.setId(id);
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

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public CategoryStatus getCategory() {
        return category;
    }

    public void setCategory(CategoryStatus category) {
        this.category = category;
    }

    // public Integer getCapacity() {
    //     return capacity;
    // }

    // public void setCapacity(Integer capacity) {
    //     if (capacity < 0) {
    //         throw new IllegalArgumentException("Capacity cannot be negative");
    //     }
    //     this.capacity = capacity;
    // }

    // public EventStatus getStatus() {
    //     return status;
    // }

    // public void setStatus(EventStatus status) {
    //     this.status = status;
    // }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", venue='" + venue + '\'' +
                ", date=" + date +
                ", time=" + time +
                ", category=" + category +
                ", description='" + description + '\'' +
                '}';
    }
}
