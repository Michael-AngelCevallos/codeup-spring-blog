package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {

    // GET /posts
    @GetMapping("/posts/")
    public String getAllPosts() {
        // return string describing the posts index page
        return "This is the posts index page";
    }

    // GET /posts/{id}
    @GetMapping("/posts/{id}")
    public String getPostById(@PathVariable Long id) {
        // return string describing viewing an individual post
        return "Viewing post with ID: " + id;
    }

    // GET /posts/create
    @GetMapping("/posts/create")
    public String getCreatePostForm() {
        // return string describing viewing the form for creating a post
        return "Viewing the form for creating a post";
    }

    // POST /posts/create
    @PostMapping("/posts/create")
    public String createPost(@RequestParam String title, @RequestParam String body) {
        // create new post using the title and body parameters
        // return string describing creating a new post
        return "Creating a new post with title: " + title + " and body: " + body;
    }
}
