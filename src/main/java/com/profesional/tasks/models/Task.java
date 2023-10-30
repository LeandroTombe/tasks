package com.profesional.tasks.models;


import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "tareas")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @Column(name = "name")
    @NotNull(message = "El nombre de la tarea no puede estar en blanco")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "active")
    private Boolean active;


    @Column(name = "complete")
    private Boolean complete;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "date_updated")
    private Date dateUpdated;


    public Task() {
    }

    public Task(String name, String description, Boolean active, Boolean complete) {
        this.name = name;
        this.description = description;
        this.active = active;
        this.complete = complete;
    }

    public Task( String name, String description, Boolean active, Boolean complete, Date dateUpdated) {
        this.name = name;
        this.description = description;
        this.active = active;
        this.complete = complete;
        this.dateUpdated = dateUpdated;
    }

    public Long getTaskId() {
        return taskId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
