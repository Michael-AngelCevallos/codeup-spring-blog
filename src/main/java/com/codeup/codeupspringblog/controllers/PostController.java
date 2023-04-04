package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.*;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.ProductsRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import com.codeup.codeupspringblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class PostController {

    //    =====Post Dependency Injection - uses a Repo in a controller, and allows all methods of  repo interface to be implemented here( 14 and lines 16-18)
    private final PostRepository postDao;
    private final UserRepository userDao;
    private final ProductsRepository productsDao;

    private final EmailService emailService;

    //can have multiple dependency's here for example  adding comments: (you must make commentRep
//    private CommentRepository commentDao;
    public PostController(PostRepository postDao, UserRepository userDao, ProductsRepository productsDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.productsDao = productsDao;
        this.emailService = emailService;
    }


//    @GetMapping("/posts")
//    public String returnPosts(Model model) {
//        // these add the actual new post on the new refreshed index page( they both do the same use ONE)
////        List<Post> post = postDao.findAll();
//        model.addAttribute("posts", postDao.findAll());
//        return "posts/index";
//    }

    @GetMapping("/posts/{id}")
    public String returnPost(@PathVariable Long id, Model model) {
        Optional<Post> post = postDao.findById(id);
        model.addAttribute(post == null ? new Post("not found", "Could not find that ad") : post);// returns post by id when you go to the id by url(for ex: .... /posts/2)
        // Optional<Post> optionalPost = postDao.findById(id); // THIS DOES SAME  AS ABOVE BUT WILL THROW ERROR IF ID VALUE OF POSTS IS NULL
        model.addAttribute("post", post);
        return "posts/show";
    }

//    @GetMapping("/posts/create")
//    public String showCreateForm(Model model) {
//        model.addAttribute("post", new Post());
//        return "posts/create";
//    }


    @PostMapping("/posts/create")// this need to be same as the one in the th:action in create.html
    public String createPost(@RequestParam(name = "title") String title, @RequestParam(name = "body") String body) {
        //Or you can use this to create a random user everytime you create a new ad
        User user = Users.randomUser(userDao);
        Post post = new Post(title, body, user);
        postDao.save(post);
        return "redirect:/posts";
    }


    //return JSON List format to html
    @GetMapping("/jpa/1")
    @ResponseBody
    public List<Product> getAllProducts() {
        return productsDao.findAll();
    }

/*  @GetMapping("/jpa/2")
  @ResponseBody
  public List<Product> getAllByCostInCents(){
        return productsDao.findByCostInCents();
  }*/


//    @GetMapping("/posts/edit")
//
//    public String editPost() {
//        Post editPost = new Post(1L, "Updated Title", "Update Body"); // creates a post in memory BUT NOT in the DATABASE
//        postDao.save(editPost); // THIS SAVES IT IN MYSQL DATABASE
//        return "redirect:/posts";
//    }


    /**
     * FORM-MODEL BINDING VERSION OF ABOVE ( USE HTML ->> index2.html for these examples)
     */


    @GetMapping("/posts1")
    public String returnPosts(Model model) {
        // these add the actual new post on the new refreshed index page( they both do the same use ONE)
//        List<Post> post = postDao.findAll();
        model.addAttribute("post", postDao.findAll());
        return "posts/formModelBinding/index2";
    }


    @GetMapping("/posts1/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "/posts/formModelBinding/create";
    }

    @PostMapping("posts1/create")
    public String postCreateForm(@ModelAttribute Post post, Principal principal){
        String username = principal.getName(); // sets logged in user the owner of new created post
        User user = userDao.findByUsername(username);
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts1";
    }

    @GetMapping("/posts1/{id}/edit")
    public String editPost(@PathVariable(name = "id") Long id, Model model ){

//        User user = userDao.findById(1L).get();
        // retrieve the post from database using id
        Post editedPost = postDao.findById(id).get();

        model.addAttribute("post", editedPost);



        if (editedPost != null) {
            model.addAttribute("post", editedPost);
            return "posts/formModelBinding/edit";
        } else {
            // handle error case when post is not found
            return "/posts1/";
        }
    }


    @PostMapping("/posts1/{id}/edit")
    public String updatePost(@PathVariable Long id, @ModelAttribute("post") Post post) {
        Post editedPost = postDao.findById(id).get();
        editedPost.setTitle(post.getTitle());
        editedPost.setBody(post.getBody());
        // update the post in database using id
        postDao.save(editedPost);
        return "redirect:/posts1/" + post.getId();
    }

    @GetMapping("/test")
    public String welcome(){
    emailService.prepareAndSend("test", "this is a test");
        System.out.println("Email Sent!");
         return "/home";
}

@GetMapping("/test2")
public String secondTest(){
        emailService.prepareAndSend("Second Test", "This is My second Test");
        return "/home";
}


    }








