package org.senai.m2s06.task.model;

import org.senai.m2s06.task.model.enums.PriorityEnum;
import org.senai.m2s06.task.model.enums.StatusEnum;

public class Task {
    private Integer id;
    private String description;
    private StatusEnum status;
    private PriorityEnum priority;
    private String assigneeName;

    public Task() {
    }

    public Task(Integer id, String description, StatusEnum status, PriorityEnum priority, String assigneeName) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.assigneeName = assigneeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public PriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(PriorityEnum priority) {
        this.priority = priority;
    }

    public String getAssigneeName() {
        return assigneeName;
    }

    public void setAssigneeName(String assigneeName) {
        this.assigneeName = assigneeName;
    }
}
