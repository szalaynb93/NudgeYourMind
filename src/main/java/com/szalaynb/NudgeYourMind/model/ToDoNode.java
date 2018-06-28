package com.szalaynb.NudgeYourMind.model;

import com.szalaynb.NudgeYourMind.model.enums.Color;
import com.szalaynb.NudgeYourMind.model.enums.Priority;
import com.szalaynb.NudgeYourMind.model.enums.Urgency;

import javax.persistence.*;
import java.util.Arrays;

@Entity
public class ToDoNode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String toDoName;

    @Enumerated
    private Urgency urgency;
    @Enumerated
    private Color color;
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

    public ToDoNode(String toDoName, Urgency urgency, int duration, Priority priority,
                    Project project) {
        this.toDoName = toDoName;
        this.urgency = urgency;
        this.duration = duration;
        this.priority = priority;
        this.project = project;
        for (Color color : Arrays.asList(Color.WHITE, Color.YELLOW, Color.ORANGE, Color.RED, Color.BROWN)) {
            if (color.getValue() == urgency.getValue() + priority.getValue()) {
                this.color = color;
                break;
            }
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Urgency getUrgency() {
        return urgency;
    }

    public void setUrgency(Urgency urgency) {
        this.urgency = urgency;
    }

    public void setUrgent(Urgency urgency) {
        this.urgency = urgency;
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
