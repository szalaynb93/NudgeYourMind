package com.szalaynb.NudgeYourMind.model;

import com.szalaynb.NudgeYourMind.model.enums.Color;

import java.util.List;

public abstract class Room {

    private long id;
    private String name;
    private List<Project> roomsProjectList;
    private Color themeColor;
//    roadSignal is indicating the top priority stuff's color inside a room and
//     on the outside of it
    private Color roadSignal;

/*    TODO: creating calculateRoadSignal() function
    this.roadSignal => for(COLOR color in Color){
                        if(roadSignal.getNumber()==(rooms.projects.getHighestPriority()
                        + rooms.projects.getMostUrgent()) {
                           return color;
                           }}}
*/
}
