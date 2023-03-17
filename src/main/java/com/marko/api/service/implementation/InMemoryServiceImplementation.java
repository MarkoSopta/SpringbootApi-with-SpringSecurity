package com.marko.api.service.implementation;

import com.marko.api.model.User;
import com.marko.api.repository.InMemoryUserRepository;
import com.marko.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class InMemoryServiceImplementation implements UserService {
    private final InMemoryUserRepository inMemoryUserRepository;

    @Override
    public User addUser(User user) {
        return inMemoryUserRepository.addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return inMemoryUserRepository.getAllUsers();
    }

    @Override
    public User findById(Integer id) {
        return inMemoryUserRepository.findById(id);
    }

//    @Override
//    public User updateUser(User user) {
//       return inMemoryUserRepository.updateUser(user);
//    }

    @Override
    public Boolean deleteById(Integer id) {
        return inMemoryUserRepository.deleteById(id);
    }
}
