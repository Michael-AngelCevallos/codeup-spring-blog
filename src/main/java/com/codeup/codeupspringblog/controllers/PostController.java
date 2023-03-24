package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    // GET /posts
    @GetMapping("/posts")
    @ResponseBody
    public String returnPosts() {
        // return string describing the posts index page
        return "This is the posts index page";
    }

    // GET /posts/{id}
    @GetMapping("/posts/{id}")
    @ResponseBody
    public String returnPost(@PathVariable long id) {
        // return string describing viewing an individual post
        return "Viewing post with ID: " + id;
    }

    // GET /posts/create
    @GetMapping("/posts/create")
    public String postCreateForm() {
        // return string describing viewing the form for creating a post
        return "index";
    }


//     POST /posts/create
    @PostMapping("/posts/create")
    public String createPost(@RequestParam String title, @RequestParam String body) {
        System.out.println(title);
        System.out.println(body);

       return "redirect:/posts";





    }
}
