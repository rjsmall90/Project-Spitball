package com.passionproject.project_spitball20.service;


import com.passionproject.project_spitball20.model.User;
import com.passionproject.project_spitball20.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    public void delete(User user) {
        userRepository.delete(user);
    }

    public User findEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User find(Long id) {
        return userRepository.findById(id).get();
    }

    public User getLoggedInUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth != null ? userRepository.findByEmail(auth.getName()) : null;
    }


}
