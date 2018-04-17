package com.szalaynb.NudgeYourMind.model;

import com.szalaynb.NudgeYourMind.model.enums.Color;

import javax.persistence.*;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Enumerated
    private Color color;

    public Project(String name) {
        this.name = name;
    }

    public Project(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
