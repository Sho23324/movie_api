package com.sho.MovieApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sho.MovieApi.model.User;
import com.sho.MovieApi.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }
    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void updateUser(Long userId, User updateUser) {
        userRepository.save(updateUser);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

}
