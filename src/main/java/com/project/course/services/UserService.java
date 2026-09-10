package com.project.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.course.entities.User;
import com.project.course.repositories.UserRepository;
import com.project.course.services.exceptions.ResourceNotFoundException;

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

        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user){
        return userRepository.save(user);
    }

    public void delete(Long id){
        userRepository.deleteById(id);
    }

    public User update(Long id, User updateDataUser){
        if(updateDataUser.getName() == null
        || updateDataUser.getEmail() == null
        || updateDataUser.getPhone() == null){
            throw new IllegalArgumentException("All fields are required.");
        }

        User userFromDataBase = userRepository.getReferenceById(id);

        userFromDataBase.setName(updateDataUser.getName());
        userFromDataBase.setEmail(updateDataUser.getEmail());
        userFromDataBase.setPhone(updateDataUser.getPhone());
        
        userRepository.save(userFromDataBase);

        return userFromDataBase;
    }
}
