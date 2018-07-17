package com.szalaynb.NudgeYourMind.controller;

import com.szalaynb.NudgeYourMind.model.Link;
import com.szalaynb.NudgeYourMind.model.Room;
import com.szalaynb.NudgeYourMind.service.LinkService;
import com.szalaynb.NudgeYourMind.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LinkController {

    private final LinkService linkService;

    private final RoomService roomService;

    @Autowired
    public LinkController(LinkService linkService, RoomService roomService) {
        this.linkService = linkService;
        this.roomService = roomService;
    }

    @PostMapping(value = "/add_link")
    public String saveLink(@RequestParam Map<String, String> queryParameters, HttpSession session) {
        String name = queryParameters.get("link_name");
        String url = queryParameters.get("link_url");
        Long roomId = Long.parseLong(session.getAttribute("room_id").toString(), 10);
        Room room = roomService.findById(roomId);
        linkService.saveLink(new Link(name, url, room));
        System.out.println("\n link saved \n");
        return "redirect:/room/" + roomId;
    }

    @PostMapping(value = "/delete_link")
    public @ResponseBody void deleteLink(@RequestParam Map<String, String> queryParameters) {
        Long linkId = Long.parseLong(queryParameters.get("linkId"),10);
        linkService.deleteLink(linkId);
        System.out.println("\n link deleted \n");
    }

}
