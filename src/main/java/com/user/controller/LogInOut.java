package com.user.controller;

import com.user.dao.entity.User;
import com.user.dto.input.LoginDto;
import com.user.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/login")
public class LogInOut {

    private final UserService userService;

    private AuthenticationManager authenticationManager;

    @Autowired
    public LogInOut(UserService userService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/guestPage")
    public String register() {
        return "guestPage";
    }

    @GetMapping("/in")
    public String login() {
        return "login";
    }

    @PostMapping("/in")
    public String loginIn(@ModelAttribute LoginDto loginDto, HttpServletRequest request) {
        /**
         * Creation object UsernamePasswordAuthenticationToken:
         */
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());
        /**
         *User Authentication:
         */
        Authentication authentication = authenticationManager.authenticate(authToken);
        /**
         * Setting object Authentication to SecurityContext:
         * line setting successfully authenticated object
         */
        SecurityContextHolder.getContext().setAuthentication(authentication);
        /**
         * save SecurityContext to session:
         */
        request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
        User user = userService.findByUsername(loginDto.getUsername());
        return "redirect:/homepage?userId=" + user.getId();
    }

    /**
     * exit from application
     *
     * @return
     */
    @PostMapping("/out")
    public String logout() {
        return "guestPage";
    }

}
