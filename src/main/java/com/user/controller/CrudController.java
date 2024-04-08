package com.user.controller;

import com.user.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class CrudController {

    @GetMapping("/")
    public String getUser(Model model) {
        model.addAttribute("message", "Hello, Spring MVC!");
        return "hello";
    }

    @PostMapping("/")
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
        // Здесь логика регистрации пользователя, например, сохранение в базе данных
        return "redirect:/register?success";
    }

    @PutMapping("/")
    public String update(Model model) {
        model.addAttribute("message", "Hello, Spring MVC!");
        return "hello";
    }

    @DeleteMapping("/")
    public String delete(Model model) {
        model.addAttribute("message", "Hello, Spring MVC!");
        return "hello";
    }
}
