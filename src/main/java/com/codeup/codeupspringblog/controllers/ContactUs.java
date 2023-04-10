package com.codeup.codeupspringblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ContactUs {


    @GetMapping("/contactUs")
    public String goToContactUsPage(){
        return "/contactUs";
    }


    @GetMapping("/aboutUs")
    public String goToAboutUsPage(){
        return "/aboutUs";
    }
}
