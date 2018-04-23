package com.szalaynb.NudgeYourMind.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(mappedBy = "project")
    private List<ToDoNode> toDoNodeList;

    public Project() {
    }

    public Project(String name) {
        this.name = name;
    }

    public List<ToDoNode> getToDoNodeList() {
        return toDoNodeList;
    }
    //@Enumerated
    //private Color color;

    public void setToDoNodeList(List<ToDoNode> toDoNodeList) {
        this.toDoNodeList = toDoNodeList;
    }

//    public Project(String name, Color color) {
//        this.name = name;
//        this.color = color;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Color getColor() {
//        return color;
//    }
//
//    public void setColor(Color color) {
//        this.color = color;
//    }
}
