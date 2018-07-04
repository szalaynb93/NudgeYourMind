package com.szalaynb.NudgeYourMind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping(value = "/home")
    public String home() {
        return "home";
    }

    @GetMapping(value = {"/", "/index"})
    public String getHomePage(Model model) {
        return "index";
    }
}
