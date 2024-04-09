package com.user.controller;

import com.user.dao.User;
import com.user.dto.UserRegistrationDto;
import com.user.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@RequestMapping("/")
public class CrudController {

    private UserService userService;

    @Autowired
    public CrudController(UserService userService) {
        this.userService = userService;
    }

    // CREATE USER
    @PostMapping("/register")
    public String registerUserAccount(@ModelAttribute UserRegistrationDto registrationDto, RedirectAttributes redirectAttributes) {
        User user = userService.create(registrationDto);
        redirectAttributes.addFlashAttribute("userId", user.getId());
        return "redirect:/homepage";
    }

    // REDIRECT TO HOMEPAGE
    @GetMapping("/homepage")
    public String displayHomePage(@ModelAttribute("userId") UUID userId, Model model) {
        User user = userService.readById(userId);
        model.addAttribute("user", user);
        return "homepage";
    }

    //REDIRECT TO EDITING PAGE
    @GetMapping("/editUser/{id}")
    public String showEditForm(@PathVariable("id") UUID id, Model model) {
        User user = userService.readById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    //UPDATE USER
    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute User user) {
        userService.updateWithEntity(user.getId(), user);
        return "redirect:/homepage?userId=" + user.getId();
    }

    //DELETE
    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") UUID id) {
        userService.delete(id);
        return "redirect:/login/guestPage";
    }

}
