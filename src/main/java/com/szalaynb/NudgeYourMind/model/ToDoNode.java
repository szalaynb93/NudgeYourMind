package com.szalaynb.NudgeYourMind.model;

import com.szalaynb.NudgeYourMind.model.enums.Priority;

import javax.persistence.*;

@Entity
public class ToDoNode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String toDoName;

    private boolean isUrgent;

    private int duration;
    @Enumerated
    private Priority priority = Priority.P0;

    @ManyToOne
    private Project project;

    public ToDoNode() {

    }

    public ToDoNode(String toDoName) {
        this.toDoName = toDoName;
    }

    public ToDoNode(String toDoName, Project project) {
        this.toDoName = toDoName;
        this.project = project;
    }

    public ToDoNode(String toDoName, boolean isUrgent, int duration, Priority priority, Project project) {
        this.toDoName = toDoName;
        this.isUrgent = isUrgent;
        this.duration = duration;
        this.priority = priority;
        this.project = project;
    }

    public boolean isUrgent() {
        return isUrgent;
    }

    public void setUrgent(boolean urgent) {
        isUrgent = urgent;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToDoName() {
        return toDoName;
    }

    public void setToDoName(String toDoName) {
        this.toDoName = toDoName;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }
}
