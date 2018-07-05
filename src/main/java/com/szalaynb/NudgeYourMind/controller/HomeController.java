package com.szalaynb.NudgeYourMind.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@Controller
public class HomeController {

    @RequestMapping(value = "/home")
    public String home(Model model) {
//        System.out.println("\n\n\n\n\n\n");
//        System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
//        System.out.println("\n\n\n");
        return "home";
    }

    @GetMapping(value = {"/", "/index"})
    public String getHomePage(Model model) {
        return "index";
    }
}
