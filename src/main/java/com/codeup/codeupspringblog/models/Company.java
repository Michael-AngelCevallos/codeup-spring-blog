package com.codeup.codeupspringblog.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "companies")
public class Company {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String companyName;

    @Column
    private String jobBoardUrl;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Post> posts;

    @Column(nullable = false, length = 50)
    private String companyEmail;

    @Column(nullable = false)
    private String companyPassword;

    @Column(nullable = false, length = 50)
    private String companyNumber;


    public Company() {

    }


    public Company(long id, String companyName, String companyEmail, String companyPassword) {
        this.id = id;
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.companyPassword = companyPassword;
    }

    public Company(long id, String companyName, String jobBoardUrl, List<Post> post, String companyEmail, String companyPassword, String companyNumber) {
        this.id = id;
        this.companyName = companyName;
        this.jobBoardUrl = jobBoardUrl;
        this.posts = post;
        this.companyEmail = companyEmail;
        this.companyPassword = companyPassword;
        this.companyNumber = companyNumber;
    }

    public Company(String companyName, String jobBoardUrl, List<Post> post, String companyEmail, String companyNumber) {
        this.companyName = companyName;
        this.jobBoardUrl = jobBoardUrl;
        this.posts = post;
        this.companyEmail = companyEmail;
        this.companyNumber = companyNumber;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobBoardUrl() {
        return jobBoardUrl;
    }

    public void setJobBoardUrl(String jobBoardUrl) {
        this.jobBoardUrl = jobBoardUrl;
    }

    public List<Post> getPost() {
        return posts;
    }

    public void setPost(List<Post> post) {
        this.posts = post;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyPassword() {
        return companyPassword;
    }

    public void setCompanyPassword(String companyPassword) {
        this.companyPassword = companyPassword;
    }

    public String getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }
}
