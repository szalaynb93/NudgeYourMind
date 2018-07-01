package com.szalaynb.NudgeYourMind.model;

import com.szalaynb.NudgeYourMind.model.Link;
import com.szalaynb.NudgeYourMind.model.Project;
import com.szalaynb.NudgeYourMind.model.enums.Color;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    @OneToMany(mappedBy = "room")
    private List<Project> roomsProjectList;
    @OneToMany(mappedBy = "room")
    private List<Link> linkList;
    private Color themeColor;
    //    roadSignal is indicating the top priority stuff's color inside a room and
    //     on the outside of it
    private Color roadSignal;

    public Room() {
    }

    public Room(String name, Color themeColor) {

        this.name = name;
        this.themeColor = themeColor;

    }

    public List<Link> getLinkList() {
        return linkList;
    }

    public void appendLinkList(Link link) {
        this.linkList.add(link);
    }

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

    public List<Project> getRoomsProjectList() {
        return roomsProjectList;
    }

    public void setRoomsProjectList(List<Project> roomsProjectList) {
        this.roomsProjectList = roomsProjectList;
    }

    public void setLinkList(List<Link> linkList) {
        this.linkList = linkList;
    }

    public Color getThemeColor() {
        return themeColor;
    }

    public void setThemeColor(Color themeColor) {
        this.themeColor = themeColor;
    }

    public Color getRoadSignal() {
        return roadSignal;
    }

    public void setRoadSignal(Color roadSignal) {
        this.roadSignal = roadSignal;
    }

/*    TODO: creating calculateRoadSignal() function
    this.roadSignal => for(COLOR color in Color){
                        if(roadSignal.getNumber()==(rooms.projects.getHighestPriority()
                        + rooms.projects.getMostUrgent()) {
                           return color;
                           }}}
*/
}
