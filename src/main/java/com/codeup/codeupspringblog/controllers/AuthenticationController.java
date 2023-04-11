package com.codeup.codeupspringblog.controllers;



import jakarta.persistence.GeneratedValue;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public String returnLoginPage() {
        return "users/login";
    }


}