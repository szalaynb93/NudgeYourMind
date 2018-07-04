package com.szalaynb.NudgeYourMind.controller;

import com.szalaynb.NudgeYourMind.model.UserEntity;
import com.szalaynb.NudgeYourMind.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/registration")
    public String renderRegistrationPage(Model model) {
        return "registration";
    }

    @PostMapping(value = "/register")
    public String register(@RequestParam Map<String, String> queryParameters) {
        String username = queryParameters.get("username");
        String password = queryParameters.get("password");
        if (username.trim().equals("") || password.trim().equals("")) {
            System.out.println("Username or password is null");
            return "redirect:/registration";
        }
        userService.saveUser(new UserEntity(username, password));
        return "redirect:/registration";
    }

    @GetMapping(value = "/")
    public String renderLoginPage(Model model) {
        return "login_page";
    }

    @GetMapping(value = "/logout-success")
    public String logoutSuccess(Model model) {
        return renderLoginPage(model);
    }


}
