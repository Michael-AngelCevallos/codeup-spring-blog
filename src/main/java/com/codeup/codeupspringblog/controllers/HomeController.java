package com.codeup.codeupspringblog.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {


//    this should take you to main page

    @GetMapping("/home")
    public String returnLandingPage() {
        return "index";
    }

}