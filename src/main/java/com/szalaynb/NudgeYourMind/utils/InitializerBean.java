package com.szalaynb.NudgeYourMind.utils;

import com.szalaynb.NudgeYourMind.model.Link;
import com.szalaynb.NudgeYourMind.model.Room;
import com.szalaynb.NudgeYourMind.model.enums.Color;
import com.szalaynb.NudgeYourMind.model.Project;
import com.szalaynb.NudgeYourMind.model.ToDoNode;
import com.szalaynb.NudgeYourMind.model.enums.Priority;
import com.szalaynb.NudgeYourMind.model.enums.Urgency;
import com.szalaynb.NudgeYourMind.service.LinkService;
import com.szalaynb.NudgeYourMind.service.ProjectService;
import com.szalaynb.NudgeYourMind.service.RoomService;
import com.szalaynb.NudgeYourMind.service.ToDoNodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitializerBean {

    private final ToDoNodeService toDoNodeService;

    private final ProjectService projectService;

    private final LinkService linkService;

    private final RoomService roomService;

    @Autowired
    public InitializerBean(ToDoNodeService toDoNodeService, ProjectService projectService, LinkService linkService, RoomService roomService) {
        this.toDoNodeService = toDoNodeService;
        this.projectService = projectService;
        this.linkService = linkService;
        this.roomService = roomService;
    }

    @PostConstruct
    public void init() {

        if (roomService.isRoomCountZero() && projectService.isProjectCountZero() && linkService.isLinkCountZero()) {

            roomService.saveroom(new Room("Workroom", Color.BLUE));
            roomService.saveroom(new Room("Community Space", Color.VIOLET));
            roomService.saveroom(new Room("Fun Room", Color.GREY));
            roomService.saveroom(new Room("Maid's Room", Color.GREEN));
            roomService.saveroom(new Room("Gym", Color.BLACK));

            Room workRoom = roomService.findById(1L);
            Room commSpace = roomService.findById(2L);
            Room funRoom = roomService.findById(3L);
            Room maidsRoom = roomService.findById(4L);
            Room gym = roomService.findById(5L);

            projectService.saveProject(new Project("Yoga", gym));
            projectService.saveProject(new Project("Back&Biceps&Abs", gym));
            projectService.saveProject(new Project("Chest&Triceps&Calves", gym));
            projectService.saveProject(new Project("Legs&Shoulders", gym));
            projectService.saveProject(new Project("Climbing", gym));
            projectService.saveProject(new Project("Cardio", gym));
            projectService.saveProject(new Project("Applications", workRoom));
            projectService.saveProject(new Project("Personal Project", workRoom));
            projectService.saveProject(new Project("Other", workRoom));
            projectService.saveProject(new Project("Tidyness", maidsRoom));
            projectService.saveProject(new Project("Functionality and Simpliness", maidsRoom));

            linkService.savelink(new Link("TomatoTimer", "www.tomato-timer.com", workRoom));
            linkService.savelink(new Link("Facebook", "www.facebook.com", commSpace));
            linkService.savelink(new Link("Eredmények", "www.eredmenyek.com", funRoom));
            linkService.savelink(new Link("F1 Világ", "www.f1vilag.com", funRoom));
            linkService.savelink(new Link("Google Keep", "www.keep.google.com", maidsRoom));
            linkService.savelink(new Link("Naptár", "www.calendor.google.com", gym));

            Project yoga = projectService.findById(1L);
            Project cardio = projectService.findById(6L);
            Project applicatoins = projectService.findById(7L);
            Project perPro = projectService.findById(8L);
            Project tidyness = projectService.findById(10L);

            toDoNodeService.saveToDoNode(new ToDoNode("Do the ashatanga sequence",
                    Urgency.AVERAGE, 120, Priority.P1, yoga));
            toDoNodeService.saveToDoNode(new ToDoNode("Go for a run",
                    Urgency.AVERAGE, 60, Priority.P1, cardio));
            toDoNodeService.saveToDoNode(new ToDoNode("Ride up the hill",
                    Urgency.AVERAGE, 120, Priority.P1, cardio));
            toDoNodeService.saveToDoNode(new ToDoNode("Apply for the RPA opportunity",
                    Urgency.URGENT, 60, Priority.P2, applicatoins));
            toDoNodeService.saveToDoNode(new ToDoNode("Apply for the Capture IT position",
                    Urgency.URGENT, 60, Priority.P2, applicatoins));
            toDoNodeService.saveToDoNode(new ToDoNode("Rewrite Controllers",
                    Urgency.AVERAGE, 240, Priority.P2, perPro));
            toDoNodeService.saveToDoNode(new ToDoNode("Write basic frontend",
                    Urgency.AVERAGE, 480, Priority.P2, perPro));
            toDoNodeService.saveToDoNode(new ToDoNode("Create user and authentiacation",
                    Urgency.AVERAGE, 480, Priority.P2, perPro));
            toDoNodeService.saveToDoNode(new ToDoNode("Washing the dishes",
                    Urgency.URGENT, 60, Priority.P1, tidyness));
            toDoNodeService.saveToDoNode(new ToDoNode("Clean up mess",
                    Urgency.URGENT, 60, Priority.P1, tidyness));

        }











//        if (toDoNodeService.isToDoCountZero()) {
//            toDoNodeService.saveToDoNode(new ToDoNode(
//                    "Bridge",false,30, Priority.P2, sport));
//            toDoNodeService.saveToDoNode(new ToDoNode(
//                    "One handed push up",false,30, Priority.P2, sport));
//            toDoNodeService.saveToDoNode(new ToDoNode(
//                    "Handstand pushup",false,30, Priority.P2, sport));
//            toDoNodeService.saveToDoNode(new ToDoNode(
//                    "Squats",false,30, Priority.P2, sport));
//            toDoNodeService.saveToDoNode(new ToDoNode(
//                    "Deadlift",false,30, Priority.P2, sport));
//            toDoNodeService.saveToDoNode(new ToDoNode(
//                    "Pull up",false,30, Priority.P2, sport));
//
//        }
    }
}
