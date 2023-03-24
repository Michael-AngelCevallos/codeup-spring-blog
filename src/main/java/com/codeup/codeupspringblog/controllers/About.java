package com.codeup.codeupspringblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class About {


    @GetMapping("/about")
    public String returnAboutPage(){
        return "about";
    }
}
