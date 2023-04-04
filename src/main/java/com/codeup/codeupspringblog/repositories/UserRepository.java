package com.codeup.codeupspringblog.repositories;


import com.codeup.codeupspringblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);


    //USED FOR Spring Security AUTHORIZATION/AUTHENTICATION
    User findByUsername(String username);
}
