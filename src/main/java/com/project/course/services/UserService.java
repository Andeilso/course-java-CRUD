package com.project.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.course.entities.User;
import com.project.course.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        List<User> userList = userRepository.findAll();

        return userList;
    }

    public User findById(Long id){
        Optional<User> user = userRepository.findById(id);

        return user.get();
    }

    public User insert(User user){
        return userRepository.save(user);
    }
}
