package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class User {
//1. Create a User class, with (at least) fields for id, username, email, and password.
//2. In your User and Post classes, define the post - user relationship.

 /** MAKE GETTERS AND SETTERS FOR EVERY OBJECT INCLUDING THE ID, OTHERWISE DATABASE WILL GLITCH OUT*/

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false, length = 50)
    private String username;
    @Column(nullable = false, length = 50)
    private String email;
    @Column(nullable = false)
    private String password;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")// "USER" IS DEFINED IN THE POST CLASS UNDER THE MANY TO ONE METHOD
    private List<Post> posts;


    // need empty constructor for SpringBoot To Work
    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }


   // NEEDED FOR AUTHENTICATION/AUTHORIZATION - creates copy of an object with properties of another object
    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
        posts = copy.posts;
    }

}
