package com.tonnyseko.servlet.app.model.entity;

import com.tonnyseko.servlet.database.helper.DbColumn;
import com.tonnyseko.servlet.database.helper.DbTableId;

import java.io.Serializable;

public class BaseEntity implements Serializable {
    @DbTableId
    @DbColumn(columnName = "id", definition = "BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
