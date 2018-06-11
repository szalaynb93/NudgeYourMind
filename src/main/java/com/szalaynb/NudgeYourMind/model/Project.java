package com.szalaynb.NudgeYourMind.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String projectName;
    @OneToMany(mappedBy = "project")
    private List<ToDoNode> toDoNodeList;

    public Project() {
    }

    public Project(String projectName) {
        this.projectName = projectName;
    }

    public List<ToDoNode> getToDoNodeList() {
        return toDoNodeList;
    }
    //@Enumerated
    //private Color color;

    public void setToDoNodeList(List<ToDoNode> toDoNodeList) {
        this.toDoNodeList = toDoNodeList;
    }

//    public Project(String projectName, Color color) {
//        this.projectName = projectName;
//        this.color = color;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

//    public Color getColor() {
//        return color;
//    }
//
//    public void setColor(Color color) {
//        this.color = color;
//    }
}
