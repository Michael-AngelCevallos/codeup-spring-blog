package com.codeup.codeupspringblog.repositories;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



//when you extend from JpaRepository, you implement all CRUD (Create, Read, Update, Delete) Methods to Post
// You can also make your own custom methods here

public interface PostRepository extends JpaRepository <Post, Long> {  // <Data type, and Data type of Id>   <<---- goes in the brackets


    // adding this eliminates the need to make an Optional in the Controller Classes
    Post findById(long id);
}
