package com.codeup.codeupspringblog.controllers;



import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class UserController {

    private final UserRepository userDao;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }


    // Allows User To Input New User
    @GetMapping("/users/sign-up")
    public String showSignupForm(Model model){
        model.addAttribute("user", new User());
        return "/users/userSignUp";
    }

    //Creates and Saves User To Database
    @PostMapping("/users/sign-up")
    public String saveUser(@ModelAttribute User user){
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/login";
    }


    @PostMapping("/users/{id}/update")
    //    // Update user by ID
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute User user ) {
        User updateUser = userDao.findById(id).get();
        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setUsername(user.getUsername());
        updateUser.setEmail(user.getEmail());
        userDao.save(updateUser);
        return "redirect:/home";


    }

    //     Delete user by ID
    @PostMapping("/users/{id}/delete")
    public String deleteUserById(@PathVariable("id") long id) {
        // Check if the user exists before deleting
        userDao.deleteById(id);
        return "redirect:/login";
    }

    @GetMapping("users/profile")
    public String userProfile(){
    return "/users/userProfile";
    }



}