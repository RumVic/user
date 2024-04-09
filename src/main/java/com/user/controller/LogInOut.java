package com.user.controller;


import com.user.dao.User;
import com.user.dto.LoginDto;
import com.user.service.api.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LogInOut {

    private UserService userService;

    public LogInOut(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/guestPage")
    public String register() {
        return "guestPage";
    }

    @GetMapping("/in")
    public String login() {
        return "login";
    }

    @PostMapping("/out")
    public String logout() {
        return "guestPage";
    }

}
