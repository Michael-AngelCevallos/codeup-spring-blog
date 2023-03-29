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

    public Post() {
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post(Long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }


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
}