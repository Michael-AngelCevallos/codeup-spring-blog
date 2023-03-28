package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {

//    =====Post Dependency Injection

    private PostRepository postDao;

    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }


    @GetMapping("/posts")
    public String returnPosts(Model model) {
        List<Post> posts = new ArrayList<>(Arrays.asList(
                new Post("Post on Trees", "Trees are great and sometimes green."),
                new Post("Post on Cars", "Cars are sometimes red."),
                new Post("Post on Dogs", "Dogs are sometimes blue.")
        ));
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String returnPost(@PathVariable Long id, Model model) {
        Post post = new Post("Single Post", "This is a post about a single post.");
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String returnPostCreateForm() {
        return "Viewing post create form";
    }


    @PostMapping("/posts/create")
    public String createPost() {
        return "Creating post...";
    }

}


