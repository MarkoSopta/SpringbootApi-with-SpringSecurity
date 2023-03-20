package com.marko.api.service.implementation;

import com.marko.api.dto.UserUpdateDTO;
import com.marko.api.model.User;
import com.marko.api.repository.JPAUserRepo;
import com.marko.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Qualifier(value = "mySQLUserService")

@RequiredArgsConstructor
@Service

public class JpaUserService implements UserService {
    @Autowired
    private final JPAUserRepo jpaUserRepo;


    @Override
    public User addUser(User user) {
        return jpaUserRepo.save(user);
    }

    public List<User> getAllUsers() {
        return jpaUserRepo.findAll();
    }


    public User findById(Integer id) {
        Optional<User> user = jpaUserRepo.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            System.out.println("User no found");
        }
        return null;
    }




    public User updateUser(Integer id, UserUpdateDTO userUpdateDTO) {
        Optional<User> optUser = jpaUserRepo.findById(id);
        if (optUser.isPresent()) {
            User user = optUser.get();
            user.setFirstname(userUpdateDTO.firstname());
            user.setLastname(userUpdateDTO.lastname());
            user.setEmail(userUpdateDTO.email());
            jpaUserRepo.save(user);
        } else {
           System.out.println("User bearing the id of " + id + " does not exist");
        }
        return null;
    }


    public Boolean deleteById(Integer id) {
        jpaUserRepo.deleteById(id);
        return Boolean.TRUE;
    }
}
