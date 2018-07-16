package com.passionproject.project_spitball20.service;


import com.passionproject.project_spitball20.model.User;
import com.passionproject.project_spitball20.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User save(User user) {
        return userRepository.saveAndFlush(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public User findEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findName(String displayName) {
        return userRepository.findByName(displayName);
    }

    public User find(Long id) {
        return userRepository.findById(id).get();
    }


}
