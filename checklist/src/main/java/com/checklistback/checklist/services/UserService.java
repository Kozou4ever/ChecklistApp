package com.checklistback.checklist.services;

import com.checklistback.checklist.models.User;
import com.checklistback.checklist.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserByName(String username){
        return getUserRepository().findByUsername(username);
    }

    public void saveUser(User user){
        getUserRepository().save(user);
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }
}
