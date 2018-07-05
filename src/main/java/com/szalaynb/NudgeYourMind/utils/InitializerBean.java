package com.szalaynb.NudgeYourMind.utils;

import com.szalaynb.NudgeYourMind.model.*;
import com.szalaynb.NudgeYourMind.model.enums.Color;
import com.szalaynb.NudgeYourMind.model.enums.Priority;
import com.szalaynb.NudgeYourMind.model.enums.Urgency;
import com.szalaynb.NudgeYourMind.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitializerBean {

    private final ToDoNodeService toDoNodeService;

    private final ProjectService projectService;

    private final LinkService linkService;

    private final RoomService roomService;

    private final UserService userService;

    @Autowired
    public InitializerBean(ToDoNodeService toDoNodeService, ProjectService projectService,
                           LinkService linkService, RoomService roomService, UserService userService) {
        this.toDoNodeService = toDoNodeService;
        this.projectService = projectService;
        this.linkService = linkService;
        this.roomService = roomService;
        this.userService = userService;
    }

    @PostConstruct
    public void init() {

        if (userService.isUserCountZero() &&roomService.isRoomCountZero()
                && projectService.isProjectCountZero() && linkService.isLinkCountZero()) {

            userService.saveUser(new UserEntity("bulent", "password"));

            UserEntity bulent = userService.findById(1L);

            roomService.saveRoom(new Room(bulent, "Workroom", Color.BLUE));
            roomService.saveRoom(new Room(bulent, "Community Space", Color.VIOLET));
            roomService.saveRoom(new Room(bulent, "Fun Room", Color.GREY));
            roomService.saveRoom(new Room(bulent, "Maid's Room", Color.GREEN));
            roomService.saveRoom(new Room(bulent, "Gym", Color.BLACK));

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
            projectService.saveProject(new Project("tidiness", maidsRoom));
            projectService.saveProject(new Project("Functionality and Simpliness", maidsRoom));

            linkService.savelink(new Link("TomatoTimer", "www.tomato-timer.com", workRoom));
            linkService.savelink(new Link("Facebook", "www.facebook.com", commSpace));
            linkService.savelink(new Link("Eredmények", "www.eredmenyek.com", funRoom));
            linkService.savelink(new Link("F1 Világ", "www.f1vilag.com", funRoom));
            linkService.savelink(new Link("Google Keep", "www.keep.google.com", maidsRoom));
            linkService.savelink(new Link("Naptár", "www.calendor.google.com", gym));

            Project yoga = projectService.findById(1L);
            Project cardio = projectService.findById(6L);
            Project applications = projectService.findById(7L);
            Project perPro = projectService.findById(8L);
            Project tidiness = projectService.findById(10L);

            toDoNodeService.saveToDoNode(new ToDoNode("Do the ashatanga sequence",
                    Urgency.AVERAGE, 120, Priority.P1, yoga));
            toDoNodeService.saveToDoNode(new ToDoNode("Go for a run",
                    Urgency.AVERAGE, 60, Priority.P1, cardio));
            toDoNodeService.saveToDoNode(new ToDoNode("Ride up the hill",
                    Urgency.AVERAGE, 120, Priority.P1, cardio));
            toDoNodeService.saveToDoNode(new ToDoNode("Apply for the RPA opportunity",
                    Urgency.URGENT, 60, Priority.P2, applications));
            toDoNodeService.saveToDoNode(new ToDoNode("Apply for the Capture IT position",
                    Urgency.URGENT, 60, Priority.P2, applications));
            toDoNodeService.saveToDoNode(new ToDoNode("Rewrite Controllers",
                    Urgency.AVERAGE, 240, Priority.P2, perPro));
            toDoNodeService.saveToDoNode(new ToDoNode("Write basic frontend",
                    Urgency.AVERAGE, 480, Priority.P2, perPro));
            toDoNodeService.saveToDoNode(new ToDoNode("Create user and authentiacation",
                    Urgency.AVERAGE, 480, Priority.P2, perPro));
            toDoNodeService.saveToDoNode(new ToDoNode("Washing the dishes",
                    Urgency.URGENT, 60, Priority.P1, tidiness));
            toDoNodeService.saveToDoNode(new ToDoNode("Clean up mess",
                    Urgency.URGENT, 60, Priority.P1, tidiness));

        }
    }
}
