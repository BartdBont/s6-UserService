package com.bart.UserService.Services;

import com.bart.UserService.Exceptions.UserNotFoundException;
import com.bart.UserService.Models.User;
import com.bart.UserService.Repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
    }

    public User save(User tweet) {
        return userRepository.save(tweet);
    }
}
