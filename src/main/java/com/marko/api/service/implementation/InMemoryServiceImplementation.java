package com.marko.api.service.implementation;

import com.marko.api.model.User;
import com.marko.api.repository.InMemoryUserRepository;
import com.marko.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Qualifier(value = "inMemory")
@RequiredArgsConstructor
@Service
public class InMemoryServiceImplementation implements UserService {
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

    @Override
    public User updateUser(Integer id, User user) {
        return null;
    }

    public Boolean deleteById(Integer id) {
        return inMemoryUserRepository.deleteById(id);
    }
}
