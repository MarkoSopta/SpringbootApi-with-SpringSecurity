package com.marko.api.repository;

import com.marko.api.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.TRUE;

@Repository
public class InMemoryUserRepository {
    private static final List<User> DATABASE = new ArrayList<>();
    static {
        DATABASE.add(new User(1,"test","tset","test@gmail.com"));
        DATABASE.add(new User(2,"bob","tset","bobo@gmail.com"));
        DATABASE.add(new User(3,"todd","howard","thod@gmail.com"));
    }

    void addUser(User user){
        DATABASE.add(user);
    }

    List<User> getAllUsers(){
        return List.copyOf(DATABASE);
    }

    User findById(Integer id){
        return DATABASE
                .stream()
                .filter(usr -> id.equals(usr.getId()))
                .findFirst()
                .orElseThrow();
    }

    void updateUser(User user){
        User existingUser = DATABASE.get(user.getId());

        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setEmail(user.getEmail());
        DATABASE.set(existingUser.getId(),existingUser);
    }

    Boolean deleteById(Integer id)    {
        User user = DATABASE
                .stream()
                .filter(usr -> id.equals(usr.getId()))
                .findFirst()
                .orElseThrow();
        DATABASE.remove(user);
        return TRUE;
    }
}