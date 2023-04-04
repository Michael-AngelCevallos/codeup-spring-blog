package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;


@Entity
@Table(name = "posts")
public class Post {


    @Id // TELLS HIBERNATE THIS YOUR PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) // THIS AUTO INCREMENTS ID'S WHEN CREATING NEW ITEMS
    @Column(columnDefinition = "int(11) UNSIGNED")
    private long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;
    @ManyToOne(cascade = CascadeType.PERSIST)// THIS IS RELATIONSHIP//THINK OF MANYTOONE AS , MANY POST BELONG TO ONLY ONE USER
    @JoinColumn(name = "user id")
    private User user;

//    @ManyToMany(cascade = CascadeType.PERSIST)
//    @JoinTable(
//            name = "post categories",
//            joinColumns = @JoinColumn(name = "post id"),
//            inverseJoinColumns = @JoinColumn(name = "category id")
//
//    private List<PostCategory>  categories;
//    )
//
    public Post() {
    }


    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body, User user) {
        this.title = title;
        this.body = body;
        this.user = user;
    }

//    public Post(List<PostCategory> categories) {
//        this.categories = categories;
//    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() { return id; }
    public long setId(Long id){return this.id = id;}

//    public List<PostCategory> getCategories() {
//        return categories;
//    }

//    public void setCategories(List<PostCategory> categories) {
//        this.categories = categories;
//    }
}