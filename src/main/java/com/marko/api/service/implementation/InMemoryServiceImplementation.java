package com.marko.api.service.implementation;

import com.marko.api.model.User;
import com.marko.api.repository.InMemoryUserRepository;
import com.marko.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class InMemoryServiceImplementation {
    private final InMemoryUserRepository inMemoryUserRepository;


    public User addUser(User user) {
        return inMemoryUserRepository.addUser(user);
    }


    public List<User> getAllUsers() {
        return inMemoryUserRepository.getAllUsers();
    }


    public User findById(Integer id) {
        return inMemoryUserRepository.findById(id);
    }

//    @Override
//    public User updateUser(User user) {
//       return inMemoryUserRepository.updateUser(user);
//    }


    public Boolean deleteById(Integer id) {
        return inMemoryUserRepository.deleteById(id);
    }
}
