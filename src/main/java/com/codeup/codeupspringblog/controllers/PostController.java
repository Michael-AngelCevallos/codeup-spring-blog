package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
public class PostController {

//    =====Post Dependency Injection - uses a Repo in a controller, and allows all methods of  repo interface to be implemented here( 14 and lines 16-18)
    private PostRepository postDao;

    //can have multiple dependency's here for example  adding comments: (you must make commentRep
//    private CommentRepository commentDao;



    // ALL DDependencies use only this one constructor
    public PostController(PostRepository postDao){
        this.postDao = postDao;
    }


    @GetMapping("/posts")
    public String returnPosts(Model model) {
        // these add the actual new post on the new refreshed index page( they both do the same use ONE)
//        List<Post> post = postDao.findAll();
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String returnPost(@PathVariable Long id, Model model) {
       Post post = postDao.findById(id).get();// returns post by id when you go to the id by url(for ex: .... /posts/2)
        // Optional<Post> optionalPost = postDao.findById(id); // THIS DOES SAME  AS ABOVE BUT WILL THROW ERROR IF ID VALUE OF POSTS IS NULL
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }


    @PostMapping("/posts/create")// this need to be same as the one in the th:action in create.html
    public String createPost(@RequestParam(name="title") String title, @RequestParam(name="body") String body) {
        Post newPost = new Post(title, body); // creates a post in memory BUT NOT in the DATABASE
        postDao.save(newPost); // THIS SAVES IT IN MYSQL DATABASE
        return "redirect:/posts";
    }


    @GetMapping("/posts/edit")

    public String editPost() {
        Post editPost = new Post(1L, "Updated Title", "Update Body"); // creates a post in memory BUT NOT in the DATABASE
        postDao.save(editPost); // THIS SAVES IT IN MYSQL DATABASE
        return "redirect:/posts";
    }

}



