package com.example.SystemManger.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SystemManger.repository.UserRepository;
import com.example.SystemManger.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
    public List<User> getALlUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long userId) {
        Optional<User> optionalUser = userRepository.findById((userId));
        if(optionalUser.isPresent()) {
            return  optionalUser.get();
        }
        return null;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
