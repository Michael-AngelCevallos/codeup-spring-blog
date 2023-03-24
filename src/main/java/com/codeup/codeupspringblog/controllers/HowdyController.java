package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HowdyController {

    @GetMapping("/howdy")

    public String returnHowdyPage(Model model){
        model.addAttribute("name", "Mike");
        model.addAttribute("favNum", "13");
        return "howdy";

    }




}
