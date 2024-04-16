package com.user.controller;

import com.user.dao.entity.User;
import com.user.dto.input.UserRegistrationDto;
import com.user.dto.output.UserDto;
import com.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.UUID;

@Controller
@RequestMapping("/")
public class CrudController {

    private final UserService userService;

    @Autowired
    public CrudController(UserService userService) {
        this.userService = userService;
    }

    /**
     * CREATE USER
     *
     * @param registrationDto
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/register")
    public String registerUserAccount(@ModelAttribute UserRegistrationDto registrationDto, RedirectAttributes redirectAttributes) {
        User user = userService.create(registrationDto);
        redirectAttributes.addFlashAttribute("userId", user.getId());
        return "redirect:/homepage";
    }

    /**
     * REDIRECT TO HOMEPAGE
     *
     * @param userId
     * @param model
     * @return
     */
    @GetMapping("/homepage")
    public String displayHomePage(@ModelAttribute("userId") UUID userId, Model model) {
        UserDto user = userService.readById(userId);
        model.addAttribute("user", user);
        return "homepage";
    }

    /**
     * REDIRECT TO EDITING PAGE
     *
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/editUser/{id}")
    public String showEditForm(@PathVariable("id") UUID id, Model model) {
        UserDto user = userService.readById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    /**
     * UPDATE USER
     *
     * @param user
     * @return
     */
    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute UserRegistrationDto user) {
        userService.update(user.getId(), user);
        return "redirect:/homepage?userId=" + user.getId();
    }

    /**
     * DELETE
     *
     * @param id
     * @return
     */
    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") UUID id , HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        userService.delete(id);
        return "redirect:/login/guestPage";
    }

}
