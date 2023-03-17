package com.marko.api.service;

import com.marko.api.model.User;


import java.util.List;


public interface UserService {
    //Save a user
    User addUser(User user);
    //Get all users
    List<User> getAllUsers();
    //Get 1 user
    User findById(Integer id);
    //Update user
//    User updateUser(User user);
    //Delete user
    Boolean deleteById(Integer id);
}
