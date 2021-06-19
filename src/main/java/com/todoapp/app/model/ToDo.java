package com.todoapp.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "tododata")
public class ToDo {
    @Id
    private String id;
    private String title;
    private String description;
    private boolean completeStatus;
    private String createdDate;
    private String endDate;

    public ToDo() {
    }

    public ToDo(String id, String title, String description, boolean completeStatus, String createdDate, String endDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completeStatus = completeStatus;
        this.createdDate = createdDate;
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleteStatus() {
        return completeStatus;
    }

    public void setCompleteStatus(boolean completeStatus) {
        this.completeStatus = completeStatus;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
