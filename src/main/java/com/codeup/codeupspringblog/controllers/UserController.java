package com.codeup.codeupspringblog.controllers;


import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private  UserRepository userDao;
    private PasswordEncoder passwordEncoder;


    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")// gets you to the form
    public String showRegisterPage(){
        return "/register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam(name="username") String username, @RequestParam(name="email") String email, @RequestParam(name="password") String password){
        User user = new User(username, email, password);
        userDao.save(user);
        return "redirect:/posts";
    }

    @GetMapping("/user/{id}/posts")
    public String usersAds(@PathVariable long id, Model model){
        User user = userDao.findById(id);
        List<Post> userPost =  user.getPosts();
        model.addAttribute("userPost", userPost);
        return "posts/userPosts";
    }


    //used for Security Authentification


    public UserController() {
    }




    /** You Would Need These If You didnt have Spring Security Dependency/Authentication */


        @GetMapping("/sign-up")
        public String showSignupForm(Model model){
            model.addAttribute("user", new User());
            return "users/sign-up";
        }

        @PostMapping("/sign-up")
        public String saveUser(@ModelAttribute User user){
            String hash = passwordEncoder.encode(user.getPassword());
            user.setPassword(hash);
            userDao.save(user);
            return "redirect:/login";
        }




}



