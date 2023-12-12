package com.tonnyseko.servlet.app.rest.api;

import java.io.Serializable;

import javax.ws.rs.QueryParam;

import com.tonnyseko.servlet.app.model.enums.CategoryStatus;

public class EventsFilter implements Serializable{

    @QueryParam("id")
    private Long id;

    // filter by caegory, category is an enum type in the event model class
    @QueryParam("category")
    private CategoryStatus category;

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // getters and setters
    public CategoryStatus getCategory() {
        return category;
    }

    public void setCategory(CategoryStatus category) {
        this.category = category;
    }
    
}
