package com.marko.api.resource;

import com.marko.api.dto.UserUpdateDTO;
import com.marko.api.model.User;
import com.marko.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.*;

@RestController
//@RequiredArgsConstructor
@RequestMapping(path = "/api/users")


public class UserResource {
    private final UserService userService;

    public UserResource(@Qualifier(value = "mySQLUserService") UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @GetMapping("{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") Integer id){
        return ResponseEntity.ok(userService.findById(id));
    }
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        //user.setId(userService.getAllUsers().size()+1);
        return ResponseEntity.created(getLocation(user.getId())).body((userService.addUser(user)));
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable ("id")Integer id) {
        return ResponseEntity.ok(userService.deleteById(id));
    }


    @PutMapping("{id}")
   public ResponseEntity<User> updateUser(@PathVariable ("id") Integer id,@RequestBody UserUpdateDTO userUpdateDTO ) {
       return ResponseEntity.ok(userService.updateUser(id,userUpdateDTO));
   }

    protected static URI getLocation(Integer id) {
        return fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(id).toUri();
    }
}