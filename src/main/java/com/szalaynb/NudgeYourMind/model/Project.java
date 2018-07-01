package com.szalaynb.NudgeYourMind.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String projectName;
    @ManyToOne
    private Room room;
    @OneToMany(mappedBy = "project")
    private List<ToDoNode> toDoNodeList;

    public Project() {
    }

//    public Project(String projectName) {
//        // Todo: If created with name only, then default is something
//        this.projectName = projectName;
//    }

    public Project(String projectName, Room room) {
        this.projectName = projectName;
        this.room = room;
    }

    public Room getRoom() {

        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<ToDoNode> getToDoNodeList() {
        return toDoNodeList;
    }

    public void setToDoNodeList(List<ToDoNode> toDoNodeList) {
        this.toDoNodeList = toDoNodeList;
    }

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
}
