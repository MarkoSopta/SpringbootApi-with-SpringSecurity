package com.marko.api.service.implementation;

import com.marko.api.dto.AddUserDto;
import com.marko.api.dto.UserUpdateDTO;
import com.marko.api.model.User;
import com.marko.api.repository.JPAUserRepo;
import com.marko.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
@Qualifier(value = "mySQLUserService")

@RequiredArgsConstructor
@Service

public class JpaUserService implements UserService {
    @Autowired
    private final JPAUserRepo jpaUserRepo;

    public void addUser(@RequestBody AddUserDto addUserDto) {
        User user = new User();
        user.setFirstname(addUserDto.firstname());
        user.setLastname(addUserDto.lastname());
        user.setEmail(addUserDto.email());
        jpaUserRepo.save(user);
    }


    @Override
    public User addUser(User user) {
        return null;
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

    @Override
    public User updateUser(Integer id, User user) {
        return null;
    }


    public void updateUser(Integer id, UserUpdateDTO userUpdateDTO) {
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
    }


    public Boolean deleteById(Integer id) {
        jpaUserRepo.deleteById(id);
        return Boolean.TRUE;
    }
}
