package com.codeup.codeupspringblog.models;


import com.codeup.codeupspringblog.repositories.UserRepository;

import java.util.List;
import java.util.Random;




public class Users {


    //method to return a random user  <------------------------------
    public static User randomUser(UserRepository usersDao){
        List<User> allUsers = usersDao.findAll();
        int randomInt = new Random().nextInt(allUsers.size());
        return allUsers.get(randomInt);
    }
}
