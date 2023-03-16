package com.marko.api.service;

import com.marko.api.model.User;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;


public interface UserService {
    //Save an user
    void addUser(User user);
    //Get all users
    List<User> getAllUsers();
    //Get 1 user
    User findById(Integer id);
    //Update user
    void updateUser(User user);
    //Delete user
    Boolean deleteById(Integer id);
}
