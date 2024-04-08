package com.user.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LogInOut {

    @GetMapping("/guestPage")
    public String register() {
        return "guestPage";
    }

    @GetMapping("/in")
    public String login() {
        return "login";
    }

    @GetMapping("/out")
    String logOutUser(Model model) {
        return "hello";
    }

}
